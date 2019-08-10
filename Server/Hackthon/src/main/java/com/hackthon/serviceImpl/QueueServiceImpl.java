package com.hackthon.serviceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.*;

import com.hackthon.POJO.QueueServicePOJO;
import com.hackthon.service.QueueService;

public class QueueServiceImpl  implements QueueService{
	
	private ConcurrentHashMap<String,QueueServicePOJO> queueMap;
	
	public void QueueServiceImp() {
		queueMap = new ConcurrentHashMap<String, QueueServicePOJO>();
	}
	
	
	public void addQueue(String queueName, String message){
		
		if(queueMap.containsKey(queueName)) {
			
			
			
		}
	}
	
	
	public void addQueue(String queueName, int size ) {
		
	}
	
	public Array

}
