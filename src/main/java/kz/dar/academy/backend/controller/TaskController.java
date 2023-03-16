package kz.dar.academy.backend.controller;

import kz.dar.academy.backend.model.TaskRequest;
import kz.dar.academy.backend.model.TaskResponse;
import kz.dar.academy.backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService taskService;


    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest taskRequest) {
        return taskService.createTask(taskRequest);

    }

    @PutMapping
    public TaskResponse updateTask(@RequestParam String taskId, @RequestBody TaskRequest taskRequest) {
        taskRequest.setTaskId(taskId);
        return taskService.updateTask(taskRequest);
    }

    @GetMapping
    public TaskResponse getTaskById(@RequestParam String taskId) {
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/initiator")
    public Page<TaskResponse> getTaskByInitiator(@RequestParam String initiatorId, Pageable pageable) {
        return taskService.getTaskByInitiatorId(initiatorId, pageable);

    }

    @GetMapping("/executor")
    public Page<TaskResponse> getTaskByExecutor(@RequestParam String executorId, Pageable pageable) {
        return taskService.getTaskByExecutorId(executorId, pageable);

    }
    @DeleteMapping
    public void deleteTask(@RequestParam String taskId){
        taskService.deleteTask(taskId);
    }

}
