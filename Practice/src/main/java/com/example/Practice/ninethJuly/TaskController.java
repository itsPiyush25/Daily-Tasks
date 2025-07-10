package com.example.Practice.ninethJuly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/start")
    public String startTask() {
        taskService.startBackgroundTask();
        return "Task started";
    }

    @GetMapping("/stop")
    public String stopTask() {
        taskService.stopTask();
        return "Task stop requested";
    }
}
