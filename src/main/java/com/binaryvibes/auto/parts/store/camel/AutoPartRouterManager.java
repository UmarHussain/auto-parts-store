package com.binaryvibes.auto.parts.store.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.springframework.stereotype.Component;

/**
 * File: AutoPartRouterManager.java
 * 
 * Define applications routes using camel;
 * 
 * @author Aamir Muhammad
 *
 */
public class AutoPartRouterManager implements CamelContextAware {
	
	protected CamelContext camelContext;

	public CamelContext getCamelContext() {
		return camelContext;
	}

	public void setCamelContext(CamelContext camelContext) {
		this.camelContext = camelContext;
	}
}
