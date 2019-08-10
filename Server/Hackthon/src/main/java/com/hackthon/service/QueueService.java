package com.hackthon.service;

public interface QueueService {

	String addMessageToQueue(String queueName, String message);
}
