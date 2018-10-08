package com.neo.microservicio.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neo.microservicio.models.Greeting;

@RestController
public class MainController {
	
	private final static String template = "Hellow, %s!";
	private final AtomicLong conuter =   new  AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="world") String name) {
		return new Greeting (conuter.incrementAndGet(), String.format(template, name));
	}
}
