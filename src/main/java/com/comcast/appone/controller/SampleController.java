package com.comcast.appone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.comcast.appone.model.SampleDomainModle;
import com.comcast.appone.services.impl.SampleServiceImpl;
import com.google.gson.JsonObject;

@RestController
// @RequestMapping("/asjh")
public class SampleController {
	
	@Autowired
	SampleServiceImpl sampleServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String getUserProfileData() {

		String details = sampleServiceImpl.getString();

		return details;
	}

	@RequestMapping(value = "/getInfo", method = RequestMethod.GET)
	public SampleDomainModle getInfo() {
		SampleDomainModle getinfo = sampleServiceImpl.getinfo();
		return getinfo;
	}

	@RequestMapping(value = "/getLogin", method = RequestMethod.GET)
	public @ResponseBody String getLogin() {
		String details = sampleServiceImpl.getLogin();
		return details;
	}

	@RequestMapping(value = "/wobytechffc", method = RequestMethod.GET)
	public @ResponseBody String getWObyTechIDFFC() {
		JsonObject wobytechffc = sampleServiceImpl.getWObyTechIDandFFC();
		return wobytechffc.toString();
	}

	@RequestMapping(value = "/wobyTimeslot", method = RequestMethod.GET)
	public @ResponseBody String getWObyTimeSlot() {
		JsonObject wobytechffc = sampleServiceImpl.getWOsbyTimeSlotC();
		return wobytechffc.toString();
	}

}
