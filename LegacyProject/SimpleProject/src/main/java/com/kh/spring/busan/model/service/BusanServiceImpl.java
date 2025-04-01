package com.kh.spring.busan.model.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BusanServiceImpl implements BusanService {

	private String SERVICE_KEY = "6cS7zU18aEwYZ6URVyGTnndBLl4A1BmUOQs6iXXWDOj%2BNlM3OIu78BeKLfgIKnha2%2BYWoCl%2FahimHMwqDXIBuA%3D%3D";
	
	@Override
	public String requestGetBusan(int pageNo) {
		
		if(pageNo < 1) { pageNo = 1; }
		StringBuilder sb = new StringBuilder();
		sb.append("http://apis.data.go.kr/6260000/FoodService/getFoodKr");
		sb.append("?serviceKey=" + SERVICE_KEY);
		sb.append("&pageNo="+pageNo);
		sb.append("&numOfRows=9");
		sb.append("&&resultType=json");
		
		URI uri = null;
		
		try {
			uri = new URI (sb.toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		String apiResponseData = new RestTemplate().getForObject(uri, String.class);
		
		log.info("API서버에서 응답온거 : {}", apiResponseData);
		
		return apiResponseData;
	}

	@Override
	public String requestGetBusanDetail(int pk) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
