package com.todo.dao;

import java.util.ArrayList;
import java.util.List;

import com.todo.model.Task;
import com.todo.validator.Validation;

public class TaskDaoImpl implements TaskDao {

	public void save(Task task) {
		Task t1 = new Task(2, "POJO", "completed", "rajesh");
		Task t2 = new Task(5, "writing CRUD", "In Progess", "Rajesh");
		Task t3=new Task(6,"JDBC","Yet to start", "Rajesh");
		Validation.isValidTask();
		System.out.println("Data validated..");
		List<Task> taskList1 = new ArrayList();
		taskList1.add(t1);
		taskList1.add(t2);
		taskList1.add(t3);
		List<Task> taskList = new ArrayList();
		taskList.addAll(taskList1);
		taskList.add(task);
		for (Task tasklist : taskList) {
			System.out.println(tasklist);

		}
	}

}
