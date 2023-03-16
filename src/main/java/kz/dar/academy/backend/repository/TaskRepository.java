package kz.dar.academy.backend.repository;

import kz.dar.academy.backend.model.TaskResponse;
import org.elasticsearch.tasks.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Repository;
@EnableElasticsearchRepositories
@Repository
public interface TaskRepository extends ElasticsearchRepository<TaskEntity, String> {
    TaskEntity getTaskEntityByTaskId(String taskId);
    Page<TaskEntity> getTaskEntityByInitiatorId(String initiatorId, Pageable pageable);
    Page<TaskEntity> getTaskEntityByExecutorId(String executorId, Pageable pageable);

    void deleteTaskEntityByTaskId(String taskId);

    Page<TaskResponse> getTaskEntitiesByInitiatorId(String initiatorId, Pageable pageable);

    Page<Task> getTaskEntitiesByExecutorId(String executorId, Pageable pageable);
}

