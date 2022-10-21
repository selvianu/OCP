package com.todo.test;

import java.util.Scanner;

import com.todo.dao.TaskDaoImpl;
import com.todo.dao.UserDaoImpl;
import com.todo.model.Task;
import com.todo.model.User;

public class Test {

	public static void main(String[] args) {
		User user = new User();
		Task task = new Task();
		Scanner sc = new Scanner(System.in);
		// testUser(user, sc);
		testTask(task, sc);
	}

	public static void testTask(Task task, Scanner sc) {
		System.out.println("Enter task ID");
		int taskId = sc.nextInt();
		task.setTaskId(taskId);
		System.out.println(task.getTaskId());
		System.out.println("Enter task name");
		String taskName = sc.next();
		task.setTaskName(taskName);
		System.out.println(task.getTaskName());
		System.out.println("Enter the name for whom its assigned to");
		String assignedTo = sc.next();
		task.setAssignedTo(assignedTo);
		System.out.println("Enter the status of the task");
		String status = sc.next();
		task.setTaskStatus(status);
		System.out.println("setting task" + task);
		TaskDaoImpl taskImple = new TaskDaoImpl();
		taskImple.save(task);

	}

	public static void testUser(User user, Scanner sc) {
		System.out.println("Enter user name and password");
		String userName = sc.next();
		user.setName(userName);
		String userPassword = sc.next();
		user.setPassword(userPassword);
		UserDaoImpl user1 = new UserDaoImpl();
		user1.save(user);
	}

}
