package com.pranathi.main;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.format.DateTimeFormatter;
//import java.util.List;
//import java.time.LocalDateTime;

@Document(collection = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
	DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm::ss:SS");
    @Id
    private String taskId;
    private String description;
    private int severity;
    @Autowired
    Assignee assignee;
    private int storyPoint;
    
	public Assignee getAssignee() {
		new Assignee();
		return assignee;
	}
	/*
	public void setAssignee(Assignee assignee) {
		new Assignee();
		this.assignee = assignee;
	}
	*/
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSeverity() {
		return severity;
	}
	public void setSeverity(int severity) {
		this.severity = severity;
	}
	
	public int getStoryPoint() {
		return storyPoint;
	}
	public void setStoryPoint(int storyPoint) {
		this.storyPoint = storyPoint;
	}    
	
}