package com.hackthon.serviceImpl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.*;

import org.springframework.stereotype.Component;

import com.hackthon.POJO.QueueServicePOJO;
import com.hackthon.service.QueueService;

@Component
public class QueueServiceImpl  implements QueueService{
	
	private ConcurrentHashMap<String,QueueServicePOJO> queueMap;
	
	public void QueueServiceImp() {
		
		queueMap = new ConcurrentHashMap<String, QueueServicePOJO>();
	}
	
	
	public String addMessageToQueue(String queueName, String message){
		
		QueueServicePOJO queuePojo = new QueueServicePOJO();
		Queue<String> currentQueue = new LinkedList<String>();
		
		if(queueMap.containsKey(queueName)) {
			queuePojo = queueMap.get(queueName);
			currentQueue = queuePojo.getQueue();
			if(queuePojo.getMaxSize() < currentQueue.size()) {
				currentQueue.add(message);
			}else{
				return "Maximum Queue size reached";
			}
		 
		}
		return "success";
	}
	
	
	public void addQueue(String queueName, int size ) {
		
	}


}
