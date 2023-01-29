package com.example.Task.controller;

import com.example.Task.entity.Task;
import com.example.Task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;
    @GetMapping ("/")
    public String listTask(Model model)
    {
        model.addAttribute("task", taskService.getAllTask());
        return "index";
    }
    @GetMapping("/addtaskform")
        public String addTaskForm(Model model)
    {
        Task task = new Task();
        model.addAttribute("task", task);
        return "addtaskform";
    }
    @PostMapping ("/addtask")
    public String addTask(@ModelAttribute("task") Task task)
    {
        taskService.addTask(task);
        return "index";
    }
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable(value = "id") long id)
    {
        this.taskService.deleteEntityById(id);
        //model.addAttribute("tasks", taskService.deleteEmployeeById(id));
        return"redirect:/";
    }
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable(value = "id")long id,Model model){
        Task task = taskService.getById(id);
        model.addAttribute("task", task);
        return "showeditform";
    }
    @PostMapping ("/updatetask")
    public String updateTask(@ModelAttribute("task") Task task)
    {
        taskService.addTask(task);
        return"redirect:/";
    }
}
