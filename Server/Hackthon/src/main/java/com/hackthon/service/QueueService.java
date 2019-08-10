package com.hackthon.service;

import java.util.ArrayList;
import java.util.Queue;

public interface QueueService {

	int addMessageToQueue(String queueName, String message);
	
	int deleteQueue(String queueName);
	
	int addQueue(String queueName, int maxSize);
	
	int removeAll();
	
	ArrayList<String> listQueues();
	
	Queue<String> browseQueue(String queueName);
	
	int removeItemFromQueue(String queueName);
	
	String checkFullorEmpty(String queueName);
	
	String consume(String queueName);
	
	
}
