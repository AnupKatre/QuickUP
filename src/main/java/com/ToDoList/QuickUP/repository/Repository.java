package com.ToDoList.QuickUP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ToDoList.QuickUP.entity.Task;

public interface Repository extends JpaRepository<Task,Long> {

}
