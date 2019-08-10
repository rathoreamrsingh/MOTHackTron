package com.hackthon.service;

public interface QueueService {

	int addMessageToQueue(String queueName, String message);
	
	int deleteQueue(String queueName);
	
	int addQueue(String queueName, int maxSize);
}
