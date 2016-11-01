package com.binaryvibes.auto.parts.store.rest;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.binaryvibes.auto.parts.store.rest.api.AutoPart;
import com.binaryvibes.auto.parts.store.rest.api.Order;
import com.binaryvibes.auto.parts.store.service.AutoPartManagerService;

/**
 * File: StoreTerminalController.java
 * 
 * Handles all the request coming from
 * auto part store terminal.
 * 
 * @author Aamir Muhammad
 *
 */
@RestController
@RequestMapping("/terminal")
public class StoreTerminalController {

	/** Auto part manager service **/
	@Autowired
	private AutoPartManagerService autoPartManagerService;
	
	@Autowired
	private ProducerTemplate producerTemplate;
	
	/**
	 * Get auto part from inventory with
	 * details.
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/auto/{autoPartId}/part", method = RequestMethod.GET)
	public AutoPart getAutoPart(@PathVariable("autoPartId") String id) {
		List<AutoPart> autoParts = autoPartManagerService.getAutoParts();
		AutoPart requestedAutoPart = null;
		
		for(AutoPart autoPart : autoParts) {
			if(id.equals(autoPart.getId())) {
				requestedAutoPart = autoPart;
				break;
			}
		}
		
		return requestedAutoPart;
	}
	
	/**
	 * Routine to add single auto part 
	 * to existing inventory.
	 * 
	 * @param autoPart
	 * @return
	 */
	@RequestMapping(value = "/auto/part/add", method = RequestMethod.POST)
	public ResponseEntity<String> addAutoPart(@RequestBody AutoPart autoPart) {
		return new ResponseEntity<String>(
				String.format("Autopart %s with ID %s added successfully", autoPart.getName(), autoPart.getId()),
				HttpStatus.CREATED);
	}
	
	/**
	 * Process order from terminal.
	 * 
	 * @param order
	 * @return
	 */
	@RequestMapping(value = "/auto/part/order", method = RequestMethod.POST)
	public ResponseEntity<String> postOrder(@RequestBody Order order) {
		producerTemplate.sendBody("direct:orders", order);
		return new ResponseEntity<String>(
				String.format(String.format("Your order %s successfully completed.", order.getOrderId())), HttpStatus.CREATED);
	}
}
