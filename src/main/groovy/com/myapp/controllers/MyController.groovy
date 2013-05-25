package com.myapp.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity


import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import groovy.json.JsonBuilder

@Controller
class MyController {
	
	@RequestMapping("/things")
 	ResponseEntity<String> things(Model model, HttpServletRequest req, HttpServletResponse resp) {
    
		List things = [
						[id: 1,name: 'Widget A'],
						[id: 2,name: 'Widget B'],
						[id: 3,name: 'Widget C'] ]
		
		String json = new JsonBuilder(things).toString()
	
		jsonResponse(json)
	}
	
	def jsonResponse(String json) {
		
	    HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json; charset=UTF-8");
		new ResponseEntity<String>(json, responseHeaders, HttpStatus.OK);
	}
	
	
	
}