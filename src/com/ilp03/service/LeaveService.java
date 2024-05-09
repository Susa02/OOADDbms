package com.ilp03.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp03.DAO.EmployeeLeaveDAO;
import com.ilp03.entity.LeaveRequest;

public class LeaveService {

	public void getEmployeeLeaveHistoryBasedOnEmpId() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Employee ID:");
		int empNo = scanner.nextInt();
		try {
			Connection connection = EmployeeLeaveDAO.getConnection();
			ArrayList<LeaveRequest> leaveList = EmployeeLeaveDAO.getEmployeeLeaveHistoryBasedOnEmpId(connection, empNo);
			System.out.println(
					"LeaveRequestID EmployeeFirstName EmployeeLastName StartDate EndDate   Status  ApproverName  Reason          LeaveType ");
			for (LeaveRequest leaveRequest : leaveList) {
				System.out.println("\t" + leaveRequest.getRequestId() + "\t" + leaveRequest.getEmployee().getFirstName()
						+ "   \t" + leaveRequest.getEmployee().getLastName() + "   \t" + leaveRequest.getStartDate()
						+ " " + leaveRequest.getEndDate() + " " + leaveRequest.getStatus() + "\t"
						+ leaveRequest.getApprovedBy() + "\t" + leaveRequest.getReason() + "        "
						+ leaveRequest.getLeaveType().getLeaveType());
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
