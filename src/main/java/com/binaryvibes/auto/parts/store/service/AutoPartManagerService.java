package com.binaryvibes.auto.parts.store.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.binaryvibes.auto.parts.store.rest.api.AutoPart;

/**
 * File: AutoPartManagerService.java
 * 
 * Manager service to get and save auto parts.
 * 
 * @author AutoPartManagerService
 *
 */
@Service
public class AutoPartManagerService {
	
	/**
	 * Returns list of all auto parts 
	 * exists with store.
	 * 
	 * @return
	 */
	public List<AutoPart> getAutoParts() {
		List<AutoPart> autoParts = new ArrayList<AutoPart>();
		
		AutoPart brakes = new AutoPart();
		brakes.setId("PB7856");
		brakes.setName("brembo");
		brakes.setQuantity(100);
		brakes.setPrice(256.33);
		
		autoParts.add(brakes);
		
		return autoParts;
	}

	public boolean checkAvailibity(String autoPartId) {
		for(AutoPart autoPart : getAutoParts()) {
			if(autoPartId.equals(autoPart.getId())) {
				return true;
			}
		}
		return false;
	}
}
