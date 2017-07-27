package com.herokuapp.muaytoday.dao;

import java.util.List;
import java.util.Map;

public interface MatchDao {
	public Number insert(Map params);
	public Number update(Map params);
	public Number updateResult(Map params);
	public List queryForList(String matchTerminal);
	public Number delete(Map params);
}