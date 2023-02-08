package com.pranathi.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
	DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");

    @Autowired
    private TaskRepository repository;

    //CRUD  CREATE , READ , UPDATE , DELETE


    public Task addTask(@RequestParam Task task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }

    public List<Task> findAllTasks() {
        return repository.findAll();
    }

    public Task getTaskByTaskId(String taskId){
        return repository.findById(taskId).get();
    }

    public List<Task> getTaskBySeverity(int severity){
        return  repository.findBySeverity(severity);
    }
  /*
    public List<Task> getTaskByAssignee(String assignee){
        return repository.getTasksByAssignee(assignee);
    }
    */
   
    public Task updateTask(Task taskRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        Task existingTask = repository.findById(taskRequest.getTaskId()).get();
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setSeverity(taskRequest.getSeverity());
        //existingTask.setAssignee(taskRequest.getAssignee());
        existingTask.setStoryPoint(taskRequest.getStoryPoint());
        
        existingTask.getAssignee().setName(taskRequest.getAssignee().getName());
        existingTask.getAssignee().setStatus(taskRequest.getAssignee().getStatus());
        existingTask.getAssignee().setAid(taskRequest.getAssignee().getAid());
        
        
        return repository.save(existingTask);
    }

    public String deleteTask(String taskId){
        repository.deleteById(taskId);
        return "task deleted from dashboard at"+LocalDateTime.now().format(dtf);
    }
}