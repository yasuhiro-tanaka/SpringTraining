package com.example.demo.service.master;

import java.util.List;

import com.example.demo.entity.Fruit;

public interface FruitService {
	void save(Fruit fruit);
	void update(Fruit fruit);
	void delete(Fruit fruit);
	List<Fruit> getAll();
	Fruit findByName(Fruit fruit);
}
