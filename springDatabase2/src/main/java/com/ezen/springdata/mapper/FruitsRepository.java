package com.ezen.springdata.mapper;

import java.util.List;

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
	
	public FruitDTO add2(FruitDTO fruitDTO) {
		sql.insert("Fruits.add2", fruitDTO);
		return fruitDTO;
	}
	
	public List<FruitDTO> selectAll() {
		return sql.selectList("Fruits.getAll");
	}
	
	public FruitDTO detail(Integer fid) {
		return sql.selectOne("Fruits.get", fid);
	}
	
	public boolean update(FruitDTO fruitDTO) {
		return sql.update("Fruits.fruit_update", fruitDTO) > 0;
	}
	
	public boolean delete(Integer fid) {
		return sql.delete("Fruits.fruit_delete", fid) > 0;
	}
}
