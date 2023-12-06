package com.example.demo;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.ExampleSearch1;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeDetailDTO;
import com.example.demo.specification.custom.ExampleSpecification1;

@RestController
@RequestMapping(path = "/api")
public class ExampleApiController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping(path = "/employee/list")
	public List<EmployeeDetailDTO> exampleOne(ExampleSearch1 searchParam){
		
		ExampleSpecification1 specificationOne = new ExampleSpecification1(searchParam);
		
		List<Employee> employees = employeeRepository.findAll(specificationOne);
		
		// transform Employee to EmployeeDetailDTO
		Function<Employee,EmployeeDetailDTO> converter = source -> {
			EmployeeDetailDTO target = new EmployeeDetailDTO();
			target.setId(source.getId());
			target.setFirstName(source.getFirstName());
			target.setLastName(source.getLastName());
//			target.setDepartmentNo(source.getDeptNo());
//			target.setDepartmentName(source.getDepartment().getDeptName());
			return target;
		};
		List<EmployeeDetailDTO> employeeDetails = employees.stream().map(converter).collect(Collectors.toList());
		
		return employeeDetails;
	}
	
}