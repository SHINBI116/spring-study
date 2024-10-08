package com.ezen.springdata.mapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ezen.springdata.dto.FruitDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class FruitsRepository {
	
	private final SqlSessionTemplate sql;
	
	public boolean add(FruitDTO fruitDTO) {
		return sql.insert("Fruits.add", fruitDTO) > 0;
	}
}
