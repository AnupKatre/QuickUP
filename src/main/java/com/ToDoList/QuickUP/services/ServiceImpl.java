package com.ToDoList.QuickUP.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ToDoList.QuickUP.entity.Task;
import com.ToDoList.QuickUP.repository.Repository;

@Service
public class ServiceImpl implements ProjectService {
	@Autowired
	Repository repo;
	
	@Override
	public void addTask(Task task) {
		repo.save(task);
	}

	@Override
	public List<Task> deleteTask(long id) {
		repo.deleteById(id);
		return repo.findAll();
	}

	@Override
	public List<Task> showTask() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public List<Task> updateTask(long id,Task inpTask) {
		for(Task t:repo.findAll()) {
			if(id == t.getId()) {
				if(inpTask.getTask()!="") {
					t.setTask(inpTask.getTask());
				}
				if(inpTask.getPriority()>0) {
					t.setPriority(inpTask.getPriority());
				}
				repo.save(t);
			}
		}
		return repo.findAll();
	}

	@Override
	public Task getTaskById(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

}
