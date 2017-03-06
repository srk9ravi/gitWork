package com.comcast.appone.services.impl;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comcast.appone.clientimpl.LoginClientImpl;
import com.comcast.appone.clientimpl.SampleClientImpl;
import com.comcast.appone.clientimpl.WorkOrderClientImpl;
import com.comcast.appone.model.SampleDomainModle;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class SampleServiceImpl {

	@Autowired
	SampleClientImpl sampleClientImpl;

	@Autowired
	LoginClientImpl loginClientImpl;

	@Autowired
	WorkOrderClientImpl workorderClientimpl;

	SampleDomainModle sdm = new SampleDomainModle();

	public String getString() {
		String getString = sampleClientImpl.getString();
		return getString;

	}

	public String getLogin() {
		String getLogin = loginClientImpl.getLogin();
		return getLogin;

	}

	public SampleDomainModle getinfo() {
		sdm.setName("Ravi");
		sdm.setProject("tech360");
		sdm.setMessages("Hi this is a HelloWorld App");
		return sdm;
	}

	public JsonObject getWObyTechIDandFFC() {
		String woResponse = workorderClientimpl.getWObyTechIDandFFCresponse();
		JsonArray woListArry = new JsonParser().parse(woResponse).getAsJsonArray();
		JsonArray currentWOList = new JsonArray();
		JsonArray otherWOList = new JsonArray();

		for (int i = 0; i < woListArry.size(); i++) {
			JsonObject woobj = woListArry.get(i).getAsJsonObject();
			String startTimeperiod = woobj.get("TimeSlotStartDateTime").getAsString();
			DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");
			DateTime woTimeslot = format.parseDateTime(startTimeperiod);

			DateTime dateTime = new DateTime();
			DateTime currentHourPlus = dateTime.plusHours(1);

			if (woTimeslot.isBefore(currentHourPlus)) {
				currentWOList.add(woobj);
			} else {
				otherWOList.add(woobj);
			}
		}

		JsonObject woListObject = new JsonObject();
		woListObject.add("currentTimeSlotWOs", currentWOList);
		woListObject.add("otherWOList", otherWOList);

		return woListObject;
	}

	public JsonObject getWOsbyTimeSlotC() {
		String woResponse = workorderClientimpl.getWObyTechIDandFFCresponse();
		JsonArray woListArry = new JsonParser().parse(woResponse).getAsJsonArray();
		JsonArray currentWOList = new JsonArray();
		JsonArray otherWOList = new JsonArray();

		for (int i = 0; i < woListArry.size(); i++) {
			JsonObject woobj = woListArry.get(i).getAsJsonObject();
			String startTimeperiod = woobj.get("TimeSlotStartDateTime").getAsString();
			DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ");
			DateTime woTimeslot = format.parseDateTime(startTimeperiod);

			DateTime dateTime = new DateTime();
			DateTime currentTime = dateTime.toDateTime();

			if (woTimeslot.isBefore(currentTime)) {
				currentWOList.add(woobj);
			} else {
				otherWOList.add(woobj);
			}
		}
		
		JsonObject woListObject = new JsonObject();
		woListObject.add("currentTimeSlotWOs", currentWOList);

		JsonObject woListObject2 = new JsonObject();
		woListObject2.add("otherWOList", otherWOList);

		if (otherWOList.isJsonNull()) {

		} else {

		}

		return woListObject;
	}

}
