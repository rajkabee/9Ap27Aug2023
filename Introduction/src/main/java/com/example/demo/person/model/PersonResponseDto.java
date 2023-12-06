package com.example.demo.person.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public interface PersonResponseDto {

	@JsonIgnore
	int getId();
	
	@JsonInclude(Include.NON_NULL)
	String getName();
	
	@JsonInclude(Include.NON_NULL)
	String getAddress();
	
	@JsonInclude(Include.NON_NULL)
	String getEmail();
	
	@JsonInclude(Include.NON_NULL)
	Gender getGender();
	
	
}
