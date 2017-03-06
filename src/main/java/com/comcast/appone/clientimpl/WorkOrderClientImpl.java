package com.comcast.appone.clientimpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WorkOrderClientImpl {

	RestTemplate restTemplate = new RestTemplate();

	@Autowired
	LoginClientImpl loginclientimpl;

	public String getWObyTechIDandFFCresponse() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("accessToken", loginclientimpl.getToken());
		headers.add("source", "tech360");

		HttpEntity<?> entity = new HttpEntity<>(headers);

		String currentDateWO = todaysDateforWO();
		String FFCnumber = "180691003";
		String SourceID = "ACP";
		String TechID = "0124";
		String url = "https://nextgen.g1.app.cloud.comcast.net/gateway/1.2/Inbound/workorderByTechNum?" + "SourceId="
				+ SourceID + "&FulfillmentCenter=" + FFCnumber + "&TechNum=" + TechID + "&ScheduleDate="
				+ currentDateWO;

		ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

		return exchange.getBody();
	}

	public static String todaysDateforWO() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		String todayDate = formatter.format(date);
		return todayDate;
	}
}
