package com.hackthon.POJO;
import java.util.LinkedList;
import java.util.Queue;

public class QueueServicePOJO {
	
	private Queue queue;
	private int maxSize;
	private String name;
	
	public QueueServicePOJO() {
		queue = new LinkedList<String>();
	}
	
	public Queue<String> getQueue() {
		return queue;
	}
	public void setQ(Queue<String> q) {
		this.queue = q;
	}
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
