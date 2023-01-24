package com.app.learnspringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.learnspringboot.pojo.CurrencyServiceConfig;

@RestController
public class CurrencyConfigController {

	@Autowired
	private CurrencyServiceConfig conf;
	
	@GetMapping("/curr-config")
	public CurrencyServiceConfig retriveAllCourse(){
		System.out.println("in service controller");
		return conf; 
	}
}
