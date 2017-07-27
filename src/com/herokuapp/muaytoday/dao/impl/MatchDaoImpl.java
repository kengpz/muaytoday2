package com.herokuapp.muaytoday.dao.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.herokuapp.muaytoday.dao.MatchDao;

public class MatchDaoImpl implements MatchDao {
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public Number insert(Map params) {
		String sql = "INSERT INTO MATCHDAY (MATCHTERMINAL, SEQUENCE, REDCORNER, BLUECORNER, WEIGHT, PREDICTION, RESULT, REMARK) VALUES (:MATCHTERMINAL, :SEQUENCE, :REDCORNER, :BLUECORNER, :WEIGHT, :PREDICTION, :RESULT, :REMARK)";

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("MATCHTERMINAL", params.get("matchterminal"));
		paramSource.addValue("SEQUENCE", Integer.parseInt(String.valueOf(params.get("sequence"))));
		paramSource.addValue("REDCORNER", params.get("redcorner"));
		paramSource.addValue("BLUECORNER", params.get("bluecorner"));
		paramSource.addValue("WEIGHT", params.get("weight"));
		paramSource.addValue("PREDICTION", params.get("prediction"));
		paramSource.addValue("RESULT", params.get("result"));
		paramSource.addValue("REMARK", params.get("remark"));

		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql, paramSource, keyHolder, new String[] { "matchid" }) ;

		return keyHolder.getKey();
	}

	public Number update(Map params) {
		String sql = "UPDATE MATCHDAY SET RESULT = :RESULT, REMARK = :REMARK WHERE MATCHTERMINAL = :MATCHTERMINAL";

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("MATCHTERMINAL", params.get("matchterminal"));
		paramSource.addValue("SEQUENCE", params.get("sequence"));
		paramSource.addValue("REDCORNER", params.get("redcorner"));
		paramSource.addValue("BLUECORNER", params.get("bluecorner"));
		paramSource.addValue("WEIGHT", params.get("weight"));
		paramSource.addValue("PREDICTION", params.get("prediction"));
		paramSource.addValue("RESULT", params.get("result"));
		paramSource.addValue("REMARK", params.get("remark"));
		Number result = namedParameterJdbcTemplate.update(sql, paramSource);

		return result;
	}

	public Number delete(Map params) {
		String sql = "DELETE FROM MATCHDAY WHERE MATCHTERMINAL = :MATCHTERMINAL";

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("MATCHTERMINAL", params.get("matchterminal"));
		Number result = namedParameterJdbcTemplate.update(sql, paramSource);

		return result;
	}

	public Number updateResult(Map params) {
		String sql = "UPDATE MATCHDAY SET RESULT = :RESULT, REMARK = :REMARK WHERE MATCHTERMINAL = :MATCHTERMINAL";

		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("MATCHTERMINAL", params.get("MATCHTERMINAL"));
		paramSource.addValue("RESULT", params.get("RESULT"));
		paramSource.addValue("REMARK", params.get("REMARK"));
		Number result = namedParameterJdbcTemplate.update(sql, paramSource) ;

		return result;
	}

	public List queryForList(String matchTerminal) {
		String sql = "SELECT * FROM MATCHDAY WHERE MATCHTERMINAL LIKE '%" + matchTerminal + "%'";
		List list = jdbcTemplate.queryForList(sql);

		return list;
	}
}