package com.binaryvibes.auto.parts.store.rest;

import com.binaryvibes.auto.parts.store.rest.api.AutoPart;
import com.google.common.collect.ImmutableMap;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.binaryvibes.auto.parts.store.rest.api.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * File: StoreOnlineController.java
 * <p>
 * Handles all the request coming from
 * auto part store online.
 *
 * @author Aamir Muhammad
 */
@RestController
@RequestMapping("/online")
public class StoreOnlineController {

    @Autowired
    private ProducerTemplate producerTemplate;

    /**
     * Process online order.
     *
     * @param order
     * @return
     */
    @RequestMapping(value = "/auto/part/order", method = RequestMethod.POST)
    public Map<String, String> postOrder(@RequestBody Order order) {
        producerTemplate.sendBody("direct:orders", order);
        return ImmutableMap.of("orderConfirmation", "Your order successfully completed");
    }
}
