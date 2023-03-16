package kz.dar.academy.backend.service;

import kz.dar.academy.backend.model.TaskRequest;
import kz.dar.academy.backend.model.TaskResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {
    TaskResponse createTask(TaskRequest taskRequest);
    TaskResponse update (TaskRequest taskRequest);
    TaskResponse getTaskById(String taskId);
    void deleteTask(String taskId);
    Page<TaskResponse>getTaskByInitiatorId(String initiatorId, Pageable pageable);
    Page<TaskResponse> getTaskByExecutorId(String executorId, Pageable pageable);

    TaskResponse updateTask(TaskRequest taskRequest);
}
