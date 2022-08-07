package com.example.demo.repository.master;

import java.util.List;

import com.example.demo.entity.Fruit;

public interface FruitDao {
	List<Fruit> getAll();
	Fruit findByName(String name);
	int insert(Fruit fruit);
	int update(Fruit fruit);
	int delete(Fruit fruit);
	
}
