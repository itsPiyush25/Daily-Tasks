package com.example.Practice.ninethJuly;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
class TaskService {
    // Volatile flag to control task execution
    private volatile boolean isRunning = true;
//    private  boolean isRunning = true;

    @Async
    public void startBackgroundTask() {
        System.out.println("Task started in thread: " + Thread.currentThread().getName());
        while (isRunning) {
            // Simulate some work
            System.out.println("Working...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Task interrupted");
                break;
            }
        }
        System.out.println("Task stopped");
    }

    public void stopTask() {
        isRunning = false; // Update visible to all threads
        System.out.println("Stop signal sent");
    }
}
