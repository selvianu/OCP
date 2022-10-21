package com.todo.model;

public class Task {
	public Task() {
		System.out.println("In Constructor");
	}

	public Task(Integer taskId, String taskName, String taskStatus, String assignedTo) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskStatus = taskStatus;
		this.assignedTo = assignedTo;
	}

	private Integer taskId;
	private String taskName;
	private String taskStatus;
	private String assignedTo;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", taskStatus=" + taskStatus + ", assignedTo="
				+ assignedTo + "]";
	}

}
