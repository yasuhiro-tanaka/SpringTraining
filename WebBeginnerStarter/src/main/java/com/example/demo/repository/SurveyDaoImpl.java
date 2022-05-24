package com.example.demo.repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Survey;

@Repository
public class SurveyDaoImpl implements SurveyDao{

	private final JdbcTemplate jdbcTemplate;

	public SurveyDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertSurvey(Survey survey) {
		//hands-on
		String sql = "INSERT INTO SURVEY(age, satisfaction, comment, created) VALUES(?, ?, ?, ?)";
		jdbcTemplate.update(sql, survey.getAge(), survey.getSatisfaction(), survey.getComment(), survey.getCreated());;

	}

	@Override
	public List<Survey> getAll() {
		//make SQL
		String sql = "SELECT id, age, satisfaction, comment, created FROM survey";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Survey> list = new ArrayList<Survey>();

		//Set the data form database into Survey instance
		for(Map<String, Object> result : resultList) {
			Survey survey = new Survey();
			survey.setId((int)result.get("id"));
			survey.setAge((int)result.get("age"));
			survey.setSatisfaction((int)result.get("satisfaction"));
			survey.setComment((String)result.get("comment"));
			survey.setCreated(((Timestamp)result.get("created")).toLocalDateTime());
			list.add(survey);
		}

		return list;
	}


}
