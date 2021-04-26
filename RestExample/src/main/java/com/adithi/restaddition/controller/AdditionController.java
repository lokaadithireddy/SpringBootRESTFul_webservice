package com.adithi.restaddition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adithi.restaddition.model.Response;
import com.adithi.restaddition.service.AddService;

@RestController
public class AdditionController {
	
	@Autowired
	private AddService addservice;
	
	
	
	@GetMapping(value="/add/first/{n1}/second/{n2}")
	public ResponseEntity<Response> add(@PathVariable int n1,@PathVariable int n2) {
//		AddService sum = new AddService();
//		sum.add(n1, n2);
		
		int sum = addservice.add(n1, n2);
		Response res = new Response();
		res.setSum(sum);
		res.setStatus("200");
		return new ResponseEntity<Response>(res, HttpStatus.OK);
		
	}
	@GetMapping(value="/addParam/")
	public ResponseEntity<Response> addParam(@RequestParam int first,@RequestParam int second) {
		
		int sum = addservice.add(first, second);
		Response res = new Response();
		res.setSum(sum);
		res.setStatus("200");
		return new ResponseEntity<Response>(res, HttpStatus.OK);
		
	}
	
}
