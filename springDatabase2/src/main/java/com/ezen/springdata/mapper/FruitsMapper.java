package com.ezen.springdata.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ezen.springdata.dto.FruitDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class FruitsMapper {
	private final SqlSessionTemplate sql;
	
	public FruitDTO add(FruitDTO fruit) {
		sql.insert("Fruits.add", fruit);
				
		return fruit;
	}
	
	public List<FruitDTO> selectAll() {
		return sql.selectList("Fruits.getAll");
	}
	
	public FruitDTO selectDetail(Integer fid) {
		return sql.selectOne("Fruits.detail", fid);
	}
	
	public boolean updateFruit(FruitDTO fruit) {
		return sql.update("Fruits.update", fruit) > 0;
	}
	
	public boolean deleteFruit(Integer fid) {
		return sql.delete("Fruits.delete", fid) > 0;
	}
}
