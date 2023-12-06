package com.example.demo.person.model;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.micrometer.common.lang.NonNull;
import jakarta.annotation.Nonnull;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequestDto {

	@JsonProperty(value = "person_id")
	int id;
	
	@Nonnull
	@JsonProperty(value = "person_name")
	String name;
	
	@JsonProperty(value = "person_address")
	String address;
	
	@NonNull
	@JsonProperty(value = "person_email")
	String email;
	
	@JsonProperty(value = "person_gender")
	@Enumerated(EnumType.STRING)
	Gender gender;
}
