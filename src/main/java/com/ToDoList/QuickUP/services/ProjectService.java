package com.ToDoList.QuickUP.services;


import java.util.List;

import com.ToDoList.QuickUP.entity.Task;

public interface ProjectService {

	void addTask(Task t);

	List<Task> deleteTask(long id);

	List<Task> showTask();

	List<Task> updateTask(long id, Task t);

	Task getTaskById(long id);


}
