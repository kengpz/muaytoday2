package com.herokuapp.muaytoday.ztest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.herokuapp.muaytoday.factory.ApplicationContextFactory;
import com.herokuapp.muaytoday.service.RestTemplateService;

public class Test_Query {

	public static void main(String[] args) {
		RestTemplateService restTemplateService = (RestTemplateService) ApplicationContextFactory.getInstance().getBean("restTemplateService");
		Map params = new HashMap();
		List result = restTemplateService.getForList("/service/management.jsp?action=getmatchtoday", params);
		System.out.println(result.size());
		
		for (int i=0; i<result.size();i++){
			Map data = (Map) result.get(i);
			System.out.println(data.get("redcorner") + " VS " + data.get("bluecorner"));
			
		}
	}

}