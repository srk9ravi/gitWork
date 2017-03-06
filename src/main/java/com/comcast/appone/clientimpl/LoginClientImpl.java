package com.comcast.appone.clientimpl;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class LoginClientImpl {
	RestTemplate restTemplate = new RestTemplate();

	public String getLogin() {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "V0dXLVRlY2hOdWNsZXVzbiR4dGckblRlY2hOdWNsZXVz");
		headers.add("Source", "technucleus");

		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<String> exchange = restTemplate.exchange(
				"https://nextgen.g2.app.cloud.comcast.net/gateway/1.0/nextgen/access", HttpMethod.GET, entity,
				String.class);

		String body = exchange.getBody();

		return body;

	}

	public String getToken() {
		String responseString = getLogin();
		JSONObject jo = new JSONObject(responseString);
		return jo.get("token").toString();
	}

}
