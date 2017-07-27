package com.herokuapp.muaytoday.service.impl;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.herokuapp.muaytoday.dao.MatchDao;
import com.herokuapp.muaytoday.service.AesCipherService;
import com.herokuapp.muaytoday.service.MatchService;

public class MatchServiceImpl implements MatchService {
	private MatchDao matchDao;
	private AesCipherService aesCipherService;

	public void setAesCipherService(AesCipherService aesCipherService) {
		this.aesCipherService = aesCipherService;
	}

	public void setMatchDao(MatchDao matchDao) {
		this.matchDao = matchDao;
	}

	public Number add(Map params) {
		return matchDao.insert(params);
	}

	public Number update(Map params) {
		return matchDao.updateResult(params);
	}

	public Number delete(Map params) {
		return matchDao.delete(params);
	}

	public Number edit(Map params) {
		return matchDao.update(params);
	}

	public List getMatchToday() {
		return matchDao.queryForList(getCurrentDate());
	}

	public static String getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		String year = String.valueOf(calendar.get(Calendar.YEAR));
		String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
		String day = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
		if (month.length() < 2) {
			month = "0" + month;
		}
		if (day.length() < 2) {
			day = "0" + day;
		}

		return year + month + day;
	}
}