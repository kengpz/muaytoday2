package com.herokuapp.muaytoday.service;

import java.util.List;
import java.util.Map;

public interface RestTemplateService {
	public String getForStringRequestUrl(String request);
	public String getForHtml(String action, Map params);
	public String getForString(String action, String json);
	public String getForString(String action, Map params);
	public Number getForNumber(String action, String json);
	public Number getForNumber(String action, Map params);
	public Map getForMap(String action, String json);
	public Map getForMap(String action, Map params);
	public List getForList(String action, String json);
	public List getForList(String action, Map params);
}