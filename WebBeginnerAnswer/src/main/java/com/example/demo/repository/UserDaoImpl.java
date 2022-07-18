package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<User> getAll() {
		String sql = "SELECT * FROM user ORDER BY id";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public User findByName(String userName) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", userName);
		String sql = "SELECT * FROM user WHERE name = :name ORDER BY id";
		return (User) jdbcTemplate.queryForObject(sql, param, new BeanPropertyRowMapper<User>(User.class));
	}

}
