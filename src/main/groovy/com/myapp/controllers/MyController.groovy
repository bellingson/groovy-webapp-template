package com.myapp.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.PathVariable

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import groovy.json.JsonBuilder

@Controller
class MyController {
	
	static List things 
	
 	static {
		things = [
			[id: 1,name: 'Widget A', img: 'http://www.easy-drawings-and-sketches.com/images/how-to-draw-a-unicorn09.jpg'],
			[id: 2,name: 'Widget B', img: 'http://gorightly.files.wordpress.com/2008/01/jesus-elvis.jpg'],
			[id: 3,name: 'Widget C', img: 'http://www.thevelvetstore.com/Merchant2/graphics/00000001/ve038-1.jpg'] ]		
	}
	
	
	
	@RequestMapping("/things")
 	ResponseEntity<String> things(HttpServletRequest request, HttpServletResponse response) {
    		
		String json = new JsonBuilder(things).toString()
	
		jsonResponse(json)
	}
	
	@RequestMapping("/thing/{id}")
 	ResponseEntity<String> thing(HttpServletRequest request, @PathVariable("id") Long id) {
    		
		Map thing
		
		things.each {
			if(it.id == id)
				thing = it
		}
		
		String json = new JsonBuilder(thing).toString()
	
		jsonResponse(json)
	}
	
	
	def jsonResponse(String json) {
		
	    HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json; charset=UTF-8");
		new ResponseEntity<String>(json, responseHeaders, HttpStatus.OK);
	}
	
	
	
}