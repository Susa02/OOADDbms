package com.ilp03.entity;

public class LeaveTypes {

	private int leaveTypeId;
	private String leaveType;
	private int numberOfLeaves;

	public LeaveTypes(int leaveTypeId, String leaveType, int numberOfLeaves) {
		super();
		this.leaveTypeId = leaveTypeId;
		this.leaveType = leaveType;
		this.numberOfLeaves = numberOfLeaves;
	}

	public int getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public int getNumberOfLeaves() {
		return numberOfLeaves;
	}

	public void setNumberOfLeaves(int numberOfLeaves) {
		this.numberOfLeaves = numberOfLeaves;
	}

}
