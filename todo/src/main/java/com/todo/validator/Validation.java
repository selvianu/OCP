package com.todo.validator;

import com.todo.dao.UserDaoImpl;
import com.todo.model.Task;
import com.todo.model.User;

public class Validation {

	public static void main(String args) {

		User user = new User();
		UserDaoImpl uimpl = new UserDaoImpl();
		String name = user.getName();
		String password = user.getPassword();
		isValidUser(name, password);

		Task task = new Task();
		System.out.println("Now starting in validator");

		isValidTask();

	}

	public static boolean isValidUser(String name, String password) {
		if ((name.trim().length() > 0) && (password.trim().length() > 3)) {
			return true;
			// uimpl.save(user);
		} else
			return false;
	}

	public static boolean isValidTask() {
		Task task = new Task();
		System.out.println("Task in validator" + task.getTaskName());
	/*	if ((task.getTaskId() > 0)
				
				&& (task.getTaskName().trim().length() >= 3)
				&& (task.getAssignedTo().trim().length() > 3) && (task.getTaskStatus().trim().length() > 3)) {
			System.out.println(task.getTaskStatus());

			System.out.println("task data validated...completed");
			return true;

		} else {
			System.out.println("Task data validation failed");
			return false;
		}*/
		return false;
	}
}
