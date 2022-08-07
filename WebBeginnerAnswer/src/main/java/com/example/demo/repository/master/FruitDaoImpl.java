package com.example.demo.repository.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Fruit;

@Repository
public class FruitDaoImpl implements FruitDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Override
	public List<Fruit> getAll() {
		String sql = "SELECT * FROM fruit ORDER BY id";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Fruit>(Fruit.class));
	}

	@Override
	public Fruit findByName(String name) {
		String sql = "SELECT * FROM fruit WHERE name = :name ORDER BY id";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("name", name);
		return (Fruit) jdbcTemplate.queryForObject(sql, param, new BeanPropertyRowMapper<Fruit>(Fruit.class));
	}

	@Override
	public int insert(Fruit fruit) {
		String sql = "INSERT INTO fruit(name, price, created) VALUES(:name, :price, :created)";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("name", fruit.getName())
				.addValue("price", fruit.getPrice())
				.addValue("created", fruit.getCreated());
		return jdbcTemplate.update(sql, param);
	}

	@Override
	public int update(Fruit fruit) {
		String sql = "UPDATE fruit SET name = :name, price = :price WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("name", fruit.getName())
				.addValue("price", fruit.getPrice())
				.addValue("id", fruit.getId());
		return jdbcTemplate.update(sql, param);
	}

	@Override
	public int delete(Fruit fruit) {
		String sql = "DELETE FROM fruit WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource()
				.addValue("id", fruit.getId());
		return jdbcTemplate.update(sql, param);
		
	}

}
