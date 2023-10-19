package com.techprimers.circuitbreaker.controller;

import com.techprimers.circuitbreaker.model.Activity;
import com.techprimers.circuitbreaker.model.Climate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequestMapping("/activity")
@RestController
public class ActivityController {

    private RestTemplate restTemplate;

    private final String BORED_API = "http://localhost:8084/prowings/climates/Sanfranscico";

    public ActivityController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    @CircuitBreaker(name = "randomActivity", fallbackMethod = "fallbackRandomActivity")
    public String getRandomActivity() {
        ResponseEntity<Climate> responseEntity = restTemplate.getForEntity(BORED_API, Climate.class);
        Climate climate= responseEntity.getBody();
        log.info("Activity received: " + climate);
        if(climate!=null)
        return "successful!!";
        else
        	return "something is wrong!!";
        	
    }

    public String fallbackRandomActivity(Throwable throwable) {
        return "Please try after some time!!";
    }

}

