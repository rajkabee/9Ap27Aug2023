package com.example.demo.person.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.person.model.Person;
import com.example.demo.person.model.PersonRequestDto;
import com.example.demo.person.model.PersonResponseDto;
import com.example.demo.person.service.PersonService;

@RestController
@RequestMapping("/people")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@PostMapping("")
	ResponseEntity<?> addPerson(@Validated @RequestBody PersonRequestDto personReq){
		//System.out.println(personReq.getName());
		Person person = new Person(personReq);
		PersonResponseDto response = personService.addPerson(person);
		return ResponseEntity.ok(response);
	}
}
