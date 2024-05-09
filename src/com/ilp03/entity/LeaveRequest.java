package com.ilp03.entity;

import java.sql.Date;

public class LeaveRequest {

	private int requestId;
	private Employees employee;
	private LeaveTypes leaveType;
	private Date startDate;
	private Date endDate;
	private String status;
	private String reason;
	private String approvedBy;

	public LeaveRequest(int requestId, Employees employee, LeaveTypes leaveType, Date startDate, Date endDate,
			String status, String reason, String approvedBy) {
		super();
		this.requestId = requestId;
		this.employee = employee;
		this.leaveType = leaveType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.reason = reason;
		this.approvedBy = approvedBy;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public LeaveTypes getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveTypes leaveType) {
		this.leaveType = leaveType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

}
