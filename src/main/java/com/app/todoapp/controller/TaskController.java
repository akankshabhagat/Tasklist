package com.app.todoapp.controller;


import com.app.todoapp.models.Task;
import com.app.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller

public class TaskController {
              private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping //
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();// we are passing data using model into htmml (ui) thymeleaf
        model.addAttribute("tasks", tasks);
        return "tasks"; // thyme leaf
    }

    @PostMapping  //
    public String createTasks(@RequestParam String title) {
        taskService. creatTask(title);
        return "redirect:/"; // thyme leaf
    }

    @GetMapping("/{id}/delete") // endpoint for delete functionality
    public String deleteTask(@PathVariable Long id) { // pathvariable tell to look into path
        taskService.deleteTask(id);
        return "redirect:/"; // thyme leaf
    }

    @GetMapping("/{id}/toggle") // endpoint for delete functionality
    public String toggleTask(@PathVariable Long id) { // pathvariable tell to look into path
        taskService.toggleTask(id);
        return "redirect:/"; // thyme leaf
    }
}
