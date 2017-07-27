package com.herokuapp.muaytoday.service;

import java.util.List;
import java.util.Map;

public interface MatchService {
	public Number add(Map params);
	public Number update(Map params);
	public Number edit(Map params);
	public Number delete(Map params);
	public List getMatchToday();
}