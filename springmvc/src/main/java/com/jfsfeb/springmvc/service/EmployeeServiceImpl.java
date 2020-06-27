package com.jfsfeb.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jfsfeb.springmvc.dao.EmployeeDAO;
import com.jfsfeb.springmvc.dto.EmployeeBean;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeDAO empdao;
	@Override
	public EmployeeBean getEmployeeByid(int id) {
		// TODO Auto-generated method stub
		return empdao.getEmployeeByid(id);
	}

	@Override
	public boolean addEmployee(EmployeeBean bean) {
		// TODO Auto-generated method stub
		return empdao.addEmployee(bean);
	}

	@Override
	public boolean updateEmployee(EmployeeBean bean) {
		// TODO Auto-generated method stub
		return empdao.updateEmployee(bean);
	}

	@Override
	public boolean deleteEmployee(int Id) {
		// TODO Auto-generated method stub
		return empdao.deleteEmployee(Id);
	}

	@Override
	public List<EmployeeBean> getAllEmployees() {
		// TODO Auto-generated method stub
		return empdao.getAllEmployees();
	}

	@Override
	public EmployeeBean authenticate(int empId, String password) {
		// TODO Auto-generated method stub
		return empdao.authenticate(empId, password);
	}
	

}