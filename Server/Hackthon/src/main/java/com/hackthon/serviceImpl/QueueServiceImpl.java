package com.hackthon.serviceImpl;

import java.util.LinkedList;
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
		queueMap.put("one", new QueueServicePOJO("one", 10));
	}
	
	
	public int addMessageToQueue(String queueName, String message){
		
		QueueServicePOJO queuePojo = null;
		Queue<String> currentQueue = new LinkedList<String>();
		
		if(queueMap.containsKey(queueName)) {
			queuePojo = queueMap.get(queueName);
			currentQueue = queuePojo.getQueue();
			if(queuePojo.getMaxSize() < currentQueue.size()) {
				currentQueue.add(message);
			}else{
				return 1;
			}
		 
		}
		return 0;
	}
	
	public int deleteQueue(String queueName) {
		
		if(queueMap.containsKey(queueName)){
			queueMap.remove(queueName);
		}else {
			return 1;
		}
		return 0;
		
	}
	
	public int addQueue(String queueName, int maxSize) {
		QueueServicePOJO  newQueue = new QueueServicePOJO(queueName,maxSize);
		if(queueMap.size()<200) {
			queueMap.put(queueName,newQueue);
		}
		else{
			return 1;
		}
		return 0;
	}
	
	public int removeAll() {
		queueMap.clear();
		return 0;
		
	}


}
