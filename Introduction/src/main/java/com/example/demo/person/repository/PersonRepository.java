package com.example.demo.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.person.model.Gender;
import com.example.demo.person.model.Person;
import com.example.demo.person.model.PersonResponseDto;
@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Integer>{
	
	@Query(value="INSERT INTO people(name, address, email, gender) VALUES (:name,:address,:email,:#{#gender.toString()})"
			, nativeQuery = true
			)
	PersonResponseDto savePerson(String name, String address, String email, Gender gender);

}
