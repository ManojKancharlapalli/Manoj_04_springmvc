package com.jfsfeb.springmvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jfsfeb.springmvc.dto.EmployeeBean;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	public EmployeeBean getEmployeeByid(int empId) {
		EmployeeBean employeeInfoBean = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=manoj123");
			pstmt = connection.prepareStatement("select * from ems_db where id=?");
			pstmt.setInt(1, empId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				employeeInfoBean = new EmployeeBean();
				employeeInfoBean.setId(rs.getInt("id"));
				employeeInfoBean.setAge(rs.getInt("age"));
				employeeInfoBean.setName(rs.getString("name"));
				employeeInfoBean.setMobilenumber(Long.parseLong(rs.getString("mobilenumber")));
				employeeInfoBean.setPassword(rs.getString("password"));
				employeeInfoBean.setEmailId("emailId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		return employeeInfoBean;
	}


	public boolean updateEmployee(EmployeeBean bean) {
		String query = "update ems_db set name=? where id=?";
		String url = "jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=manoj123";
		try (Connection connection = DriverManager.getConnection(url);
				PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			Class.forName("com.mysql.jdbc.Driver");
			preparedStatement.setString(1, bean.getName());
			preparedStatement.setInt(2, bean.getId());
			int res = preparedStatement.executeUpdate();
			if (res != 0) {
				return true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteEmployee(int empId) {

		boolean isDeleted = false;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=manoj123");
			PreparedStatement pstmt1 = connection.prepareStatement("delete from  ems_db  where id=?");

			pstmt1.setInt(1, empId);

			int result = pstmt1.executeUpdate();
			if (result > 0) {
				
				isDeleted = true;
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return isDeleted;
	}

	@Override
	public boolean addEmployee(EmployeeBean bean) {

		String query1 = "insert into ems_db values(?,?,?,?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=manoj123");

			PreparedStatement preparedStatement3 = connection.prepareStatement(query1);

			preparedStatement3.setInt(1, bean.getId());
			preparedStatement3.setString(2, bean.getName());
			preparedStatement3.setLong(3, bean.getMobilenumber());
			preparedStatement3.setString(4, bean.getEmailId());
			preparedStatement3.setString(5, bean.getPassword());
			preparedStatement3.setInt(6, bean.getAge());

			int result = preparedStatement3.executeUpdate();

			if (result != 0) {
				
				return true;
			}

			connection.close();

		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return false;
	}

	

	@Override
	public List<EmployeeBean> getAllEmployees() {
		List<EmployeeBean> listInfo = new ArrayList<EmployeeBean>();

		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp_db?useSSL=false&user=root&password=manoj123");
			PreparedStatement pstmt1 = connection.prepareStatement("select * from ems_db");
			rs = pstmt1.executeQuery();

			while (rs.next()) {
				EmployeeBean bean2 = new EmployeeBean();

				
				 bean2.setId(rs.getInt("id"));
				 bean2.setAge(rs.getInt("age"));
				 bean2.setName(rs.getString("name"));
				 bean2.setMobilenumber(Long.parseLong(rs.getString("mobilenumber")));
				 bean2.setPassword(rs.getString("password"));
				 bean2.setEmailId("emailId");

				listInfo.add(bean2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}

		return listInfo;
	}

	@Override
	public EmployeeBean authenticate(int empId, String password) {
		EmployeeBean employeeInfoBean = getEmployeeByid(empId);
		if (!(employeeInfoBean != null && employeeInfoBean.getPassword().equals(password))) {
			employeeInfoBean = null;
		}
		return null;
	}

}