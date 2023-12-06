package com.example.demo.specification.custom;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.data.ExampleSearch1;
import com.example.demo.model.Employee;
import com.example.demo.specification.SearchSpecification;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ExampleSpecification1 extends SearchSpecification<ExampleSearch1, Employee>{

	private static final long serialVersionUID = 1L;
	
	public ExampleSpecification1(ExampleSearch1 search) {
		super(search);
	}

	@Override
	public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder,
			ExampleSearch1 search) {
		
		List<Predicate> predicates = new ArrayList<>();
		if(StringUtils.isNotEmpty(search.getFirstName())) {
			Predicate likeFirstName = criteriaBuilder.like(root.get("firstName"), "%" + search.getFirstName() + "%");
			predicates.add(likeFirstName);
		}
		if(StringUtils.isNotEmpty(search.getLastName())) {
			Predicate likeLastName = criteriaBuilder.like(root.get("lastName"), "%" + search.getLastName() + "%");
			predicates.add(likeLastName);
		}
		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	}

}
