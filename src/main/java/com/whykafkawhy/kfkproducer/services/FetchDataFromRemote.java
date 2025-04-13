package com.whykafkawhy.kfkproducer.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FetchDataFromRemote {
	public String getResponseFromRemote() {
		String result = new String();
		RestTemplate resttemplate = new RestTemplate();
		String apiUrl = "https://api.polygon.io/v3/reference/dividends?order=asc&limit=10&sort=ex_dividend_date&apiKey=GLS2jYVpk6sp8XgWF5VtTDloTVYsPDHo";
		result = resttemplate.getForObject(apiUrl, String.class);
		return result; 
	}
}
