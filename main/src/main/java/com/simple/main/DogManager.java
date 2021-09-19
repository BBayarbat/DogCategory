package com.simple.main;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class DogManager {
    
    public static Map<String,List<String>> getData(){
		String url = "https://raw.githubusercontent.com/mlenze/CodingExcercise-Java/main/apidata.json";
		
		Map<String,List<String>> DogTypes = new HashMap<>();
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		HttpEntity entity = new HttpEntity();

		DogTypes = restTemplate.exchange(url, HttpMethod.GET, entity, new ParameterizedTypeReference<Map<String,List<String>>>() {});

		return DogTypes;
	}
	public static Map<String,List<String>> getAll(Map<String,List<String>> data){
		String url = "https://dog.ceo/api/breeds/list/all";
		
		Map<String,List<String>> DogTypes2 = new HashMap<>();
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		HttpEntity entity = new HttpEntity();
		
		UriComponentsBuilder builder2 = UriComponentsBuilder.fromHttpUrl(url)
        .queryParam("message", data)
        .queryParam("state", "success");

		HttpEntity<?> entity2 = new HttpEntity<>(headers);

		DogTypes2 = restTemplate.exchange(
				builder2.toUriString(), 
				HttpMethod.GET, 
				entity, 
				new ParameterizedTypeReference<Map<String,List<String>>>() {});
	}
}
