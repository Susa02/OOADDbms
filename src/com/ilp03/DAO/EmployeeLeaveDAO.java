package com.ilp03.DAO;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ilp03.entity.Employees;
import com.ilp03.entity.LeaveRequest;
import com.ilp03.entity.LeaveTypes;

public class EmployeeLeaveDAO {

	public static Connection getConnection() {
		String connectionString = "jdbc:mysql://localhost:3306/hrempleavesystem?useSSL=false";
		String userName = "root";
		String password = "Chips@2011";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<LeaveRequest> getEmployeeLeaveHistoryBasedOnEmpId(Connection connection, int empId) {
		PreparedStatement preparedStatement;
		ArrayList<LeaveRequest> leaveList = new ArrayList<LeaveRequest>();
		try {
			preparedStatement = connection.prepareStatement(
					"select lr.request_id, e_req.first_name as empFirstName, e_req.last_name as empLastName, lr.start_date, lr.end_date, lr.status,e_app.first_name as approverFirstName, lr.reason, lt.leave_type from leave_requests lr inner join leave_types lt ON lr.leave_type_id = lt.leave_type_id inner join employees e_req ON lr.emp_id = e_req.emp_id inner join employees e_app ON lr.approved_by = e_app.emp_id where lr.emp_id =?");
			preparedStatement.setInt(1, empId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int requestId = resultSet.getInt(1);
				String firstName = resultSet.getString(2);
				String lastName = resultSet.getString(3);
				Date startDate = resultSet.getDate(4);
				Date endDate = resultSet.getDate(5);
				String status = resultSet.getString(6);
				String approvedBy = resultSet.getString(7);
				String reason = resultSet.getString(8);
				String leaveType = resultSet.getString(9);

				Employees employee = new Employees(0, null, null, null, 0, null, 0, 0, null, null);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				LeaveTypes leaveTypes = new LeaveTypes(0, null, 0);
				leaveTypes.setLeaveType(leaveType);
				LeaveRequest leaveRequest = new LeaveRequest(requestId, employee, leaveTypes, startDate, endDate,
						status, reason, approvedBy);
				leaveList.add(leaveRequest);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return leaveList;

	}

}
