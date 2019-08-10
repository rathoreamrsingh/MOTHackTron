package com.hackthon.serviceImpl;


import java.util.LinkedList;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import java.util.List;


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


	public ArrayList<String> listQueues(){
		ArrayList<String> qnames = new ArrayList<String>();
		for(String key: queueMap.keySet()) {
			qnames.add(key);
		}
		return qnames;
	}
	
	public QueueServicePOJO peakQueue(String queueName) throws Exception {
		try {
			if(!queueMap.containsKey(queueName)) {
				throw new Exception("queue doesn't exist");
				
			}
			else {
				return queueMap.get(queueName);
			}
		}
		catch (Exception ex){
			throw ex;
		}
		//return peakVal;
	}
	 public int removeItemFromQueue(String queueName) {
		 try {
				if(!queueMap.containsKey(queueName)) {
					throw new Exception("queue doesn't exist");
					
				}
				else {
					QueueServicePOJO qsp = queueMap.get(queueName);
					Queue<String> que = qsp.getQueue();
					if(que.isEmpty()) return 1;
					que.remove();
					return 0;
				}
			}
			catch (Exception ex){
				throw ex;
			}
	 }
	


}
