package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DatabaseQuery;
import dto.Company;
import dto.Employee;
import factory.ConnectionFactory;

public class EmployeeDAO {

	private static EmployeeDAO employeeDAO = null;

	public static EmployeeDAO getInstance(){

		if(employeeDAO == null){
			employeeDAO = new EmployeeDAO();
		}
		return employeeDAO;
	}

	public int addEmployee(Employee employee,Company company) throws SQLException,Exception{
		
		Connection conn = null;
		CallableStatement callStmt = null;
		PreparedStatement preStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.ADD_EMPLOYEE);
			callStmt.setString(1, employee.getName());
			callStmt.setString(2, employee.getGender());
			callStmt.setString(3, employee.getEmail());
			callStmt.setString(4, employee.getPassword());
			callStmt.setString(5, employee.getPhoneNumber());
			callStmt.setInt(6, company.getId());
			
			int result = callStmt.executeUpdate();
			if(result > 0){
				preStmt = conn.prepareStatement(DatabaseQuery.GET_ID_OF_ADDED_EMPLOYEE);
				ResultSet resultId= preStmt.executeQuery();
				resultId.next();
				return resultId.getInt(1);
			}else{
				return -1;
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally{
			try{
				conn.close();
				callStmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
			}
		}
		
	}
	
	public Employee getEmployeeDetail(String email) throws SQLException,Exception{

		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.GET_EMPLOYEE_DETAIL);
			callStmt.setString(1, email);
			ResultSet result = callStmt.executeQuery();
			Employee employee = new Employee();
			while(result.next()){
				employee.setId(result.getInt(1));
				employee.setName(result.getString(2));
				employee.setGender(result.getString(3));
				employee.setEmail(result.getString(4));
				employee.setPassword(result.getString(5));
				employee.setPhoneNumber(result.getString(6));
				employee.setOrganization(result.getString(7));
			}
			return employee;
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally{
			try{
				conn.close();
				callStmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
			}
		}
	}
	
	public Employee getFriendDetail(String email) throws SQLException,Exception{

		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.GET_FRIEND_DETAIL);
			callStmt.setString(1, email);
			ResultSet result = callStmt.executeQuery();
			Employee employee = new Employee();
			while(result.next()){
				employee.setId(result.getInt(1));
				employee.setName(result.getString(2));
				employee.setGender(result.getString(3));
				employee.setEmail(result.getString(4));
				employee.setPhoneNumber(result.getString(5));
				employee.setOrganization(result.getString(6));
			}
			return employee;
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally{
			try{
				conn.close();
				callStmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
			}
		}
	}

	public boolean updateEmployeeDetail(Employee employee,String email) throws SQLException,Exception{

		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.UPDATE_EMPLOYEE_DETAIL);
			callStmt.setString(1, employee.getEmail());
			callStmt.setString(2, employee.getPassword());
			callStmt.setString(3, employee.getPhoneNumber());
			callStmt.setString(4, email);
			int result = callStmt.executeUpdate();
			if(result > 0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally{
			try{
				conn.close();
				callStmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
			}
		}
	}
	
	public List<Employee> getFriendList(String email) throws SQLException,Exception{
		
		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.GET_FRIENDS_LIST);
			callStmt.setString(1, email);
			ResultSet result = callStmt.executeQuery();
			List<Employee> friendList = new ArrayList<Employee>();
			while(result.next()){
				Employee employee = new Employee();
				employee.setId(result.getInt(1));
				employee.setName(result.getString(2));
				employee.setEmail(result.getString(3));
				friendList.add(employee);
			}
			return friendList;
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally{
			try{
				conn.close();
				callStmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
			}
		}
	}
	
	public int getEmployeeId(String email) throws SQLException,Exception{
		
		Connection conn = null;
		CallableStatement callStmt = null;
		try{
			conn = ConnectionFactory.getConnection();
			callStmt = conn.prepareCall(DatabaseQuery.GET_EMPLOYEE_ID);
			callStmt.setString(1, email);
			ResultSet result = callStmt.executeQuery();
			result.next();
			return result.getInt(1);
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		finally{
			try{
				conn.close();
				callStmt.close();
			}catch(SQLException e){
				e.printStackTrace();
				throw e;
			}
		}
	}
}
