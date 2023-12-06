package com.example.demo.person.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="people")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String address;
	String email;
	@Enumerated(EnumType.STRING)
	Gender gender;
	
	public Person(PersonRequestDto pr) {
		super();
		this.id = pr.id;
		this.name = pr.name;
		this.address = pr.address;
		this.email = pr.email;
		this.gender = pr.gender;
	}
	
	
	
}
