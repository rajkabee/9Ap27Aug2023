package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "DEPT_NO", insertable = false, updatable = false)
	private String deptNo;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "MID_NAME")
	private String midName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "PHONE")
	private String phone;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BIRTH_DATE")
	private Date birthDate;
	
//	@ManyToOne
//	@JoinColumn(name = "DEPT_NO", referencedColumnName = "DEPT_NO")
//	private Department department;
	
}

