package com.ToDoList.QuickUP.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ToDoList.QuickUP.entity.Task;
import com.ToDoList.QuickUP.services.ProjectService;

@Controller
public class MyController {
	@Autowired
	ProjectService service;
	
	@GetMapping("/")
	public String showTask(Model model){
		model.addAttribute("tasks",service.showTask());
		return "home/index";
	}
	
	@GetMapping("/task/add")
	public String addTaskForm(Model model) {
		Task t = new Task();
		model.addAttribute("t",t);
		return "createTask";
	}
	
	@PostMapping("/addtask")
	public String addTask(@ModelAttribute("t") Task t){ 
		service.addTask(t);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/deleteTask/{id}",method = RequestMethod.GET)
	public String deleteTask(@PathVariable("id") long id ){
		service.deleteTask(id);
		return "redirect:/";
	}
	
	
	
	
	@GetMapping("/update/{id}")
	public String updateTaskForm(@PathVariable long id ,Model model) {
		Task n = service.getTaskById(id);
		model.addAttribute("t",n);
		return "updateTask";
	}
	
	@PostMapping("/task/update/{id}")
	public String updateTask(@PathVariable String id,@ModelAttribute("t") Task t,Model model) {
		//model.addAttribute("tasks",service.updateTask(id, t));
		service.updateTask(Long.parseLong(id), t);
		return  "redirect:/";
	}

}
