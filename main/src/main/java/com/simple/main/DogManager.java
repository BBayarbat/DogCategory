package com.simple.main;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
public class DogManager {
    
    public static Map<String,Object> getData(){
		String url = "https://raw.githubusercontent.com/mlenze/CodingExcercise-Java/main/apidata.json";
		
		RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url,String.class);

		Type mapTokenType = new TypeToken<Map<String, Object>>(){}.getType();
        Map<String, Object> DogTypes = new Gson().fromJson(response, mapTokenType);
		
		return DogTypes;    
	}

  

	public static Map<String,Object> getAll(Map<String,Object> data){
		String url = "https://dog.ceo/api/breeds/list/all";		
		RestTemplate restTemplate = new RestTemplate();

		// create headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.set("message", data.toString());
		HttpEntity request = new HttpEntity(headers);
		ResponseEntity<String> response = restTemplate.exchange(
				url,
				HttpMethod.GET,
				request,
				String.class,
				1
		);

		Type mapTokenType = new TypeToken<Map<String, Object>>(){}.getType();
        Map<String, Object> DogTypes = new Gson().fromJson(response.getBody(), mapTokenType);

		return DogTypes;
	}
}
