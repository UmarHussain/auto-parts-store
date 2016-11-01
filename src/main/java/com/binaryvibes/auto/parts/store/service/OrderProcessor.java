package com.binaryvibes.auto.parts.store.service;

import com.binaryvibes.auto.parts.store.bpmn.AutoPartKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binaryvibes.auto.parts.store.rest.api.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * File: OrderProcessor.java
 * 
 * @author bv
 *
 */
@Service
public class OrderProcessor {

	@Autowired
	AutoPartKnowledgeSession kSession;

	public void processOrder(Order order) throws Exception {
		Map<String, Object> orderParams = new HashMap<String, Object>();
		orderParams.put("order", order);

		kSession.getStatefulKnowledgeSession().startProcess("orderProcess", orderParams);
	}
}
