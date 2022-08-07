package com.example.demo.service.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Fruit;
import com.example.demo.repository.master.FruitDao;

@Service
public class FruitServiceImpl implements FruitService {
	@Autowired
	private FruitDao dao;
	
	@Override
	public void save(Fruit fruit) {
		dao.insert(fruit);
	}

	@Override
	public void update(Fruit fruit) {
		dao.update(fruit);
	}

	@Override
	public List<Fruit> getAll() {
		return dao.getAll();
	}

	@Override
	public void delete(Fruit fruit) {
		dao.delete(fruit);
	}

	@Override
	public Fruit findByName(Fruit fruit) {
		// TODO Auto-generated method stub
		return null;
	}

}
