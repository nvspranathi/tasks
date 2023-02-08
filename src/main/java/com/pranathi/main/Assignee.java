package com.pranathi.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class Assignee {
	
	DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-YYYY hh:mm:ss.SSS");
	@Id
	private String aid;
	private String createTime;
	private String destroyTime;
	private String status;
	private String name;
 
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime() {
		this.createTime = LocalDateTime.now().format(dtf);
	}
	public String getDestroyTime() {
		return destroyTime;
	}
	public void setDestroyTime() {
		this.destroyTime=LocalDateTime.now().format(dtf);
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}