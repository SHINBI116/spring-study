package com.ezen.springdata.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.ezen.springdata.dto.EmpDeptDTO;
import com.ezen.springdata.dto.EmployeeDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class EmployeeMapper {

	private final SqlSessionTemplate sql;

	// selectList("namespace.id", parameter) :
	// Mapper파일에 설정한 이름을 전달해 Mapper에 정의된 쿼리문을 실행한다
	// 여러 줄 select를 하는 쿼리문에 사용한다
	public List<EmployeeDTO> getAll() {
		return sql.selectList("Employees.getAll");
	}

	// selectList("namespace.id", parameter) :
	// Mapper파일에 설정한 이름을 전달해 Mapper에 정의된 쿼리문을 실행한다
	// 한 줄 select를 하는 쿼리문에 사용한다 (주로 pk와 함께 사용)
	public EmployeeDTO get(Integer employee_id) {
		return sql.selectOne("Employees.get", employee_id);
	}
	
	public List<EmployeeDTO> getAllByDeptId(Integer dept_id) {
		return sql.selectList("Employees.getAllByDeptId", dept_id);
	}
	
	public EmpDeptDTO getEmpDept(Integer emp_id) {
		return sql.selectOne("Employees.getEmpDept", emp_id);
	}
	
	public List<EmployeeDTO> getAllUnderSalary(Double salary) {
		return sql.selectList("Employees.getAllEmpUnderSalary", salary);
	}
}
