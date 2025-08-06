package com.aakash.todoapp.controller;

import com.aakash.todoapp.models.Task;
import com.aakash.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class TaskController {

//    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping()
    public String getTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
//        System.out.println(tasks);
//        tasks.forEach(task -> System.out.println("Fetched: " + task));
//        System.out.println(tasks);
        model.addAttribute("tasks", tasks);

        return "tasks";
    }

    @PostMapping()
    public String createTask(@RequestParam String title){
        taskService.createTask(title);
        return "redirect:/";
    }


    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/";
    }


}
