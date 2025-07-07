package com.example.Practice.seventhJuly;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadDemo {
    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 50_000; i++) {
                int taskId = i;
                executor.submit(() -> {
                    String result = simulateApiCall(taskId);
                    System.out.println("Task " + taskId + ": " + result);
                });
            }
        }
    }
    private static String simulateApiCall(int taskId) {
        try {
            Thread.sleep(1000); // Simulate I/O delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Processed task " + taskId;
    }
}
