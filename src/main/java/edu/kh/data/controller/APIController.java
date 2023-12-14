package edu.kh.data.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController {

	private static final String serviceKey = "491QMN0WZ3KzN4hoNumwlR7sAA71O2DTn1%2B%2B0GGUutJ2%2B0ZACxtZMi1Dlwuk8PHWod3bWumR1OysjCiUX8eJ0g%3D%3D";
	
	@RequestMapping(value = "busInfo", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String busInfo() throws Exception{

		String url = "http://apis.data.go.kr/1613000/BusRouteInfoInqireService/getRouteAcctoThrghSttnList";
		url += "?serviceKey=" + serviceKey;
		url += "&cityCode=25";
		url += "&routeId=DJB30300004";
		url += "&_type=json";
		
		
		URL requestUrl = new URL(url);

		HttpURLConnection urlConnection = (HttpURLConnection) requestUrl.openConnection();

		urlConnection.setRequestMethod("GET");

		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

		String responseData = "";
		String line;

		while ((line = br.readLine()) != null) {
			responseData += line;
		}
		br.close();

		urlConnection.disconnect();

		System.out.println("responseData::" + responseData);

		return responseData;

	}

}
