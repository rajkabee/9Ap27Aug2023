package com.example.demo.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.person.model.Person;
import com.example.demo.person.model.PersonResponseDto;
import com.example.demo.person.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonRepository personRepository;
	
	@Override
	public PersonResponseDto addPerson(Person person) {
		PersonResponseDto personDto = personRepository.savePerson(person.getName(), person.getAddress(), person.getEmail(), person.getGender());
		return personDto;
	}

}
