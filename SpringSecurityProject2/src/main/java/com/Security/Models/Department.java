package com.Security.Models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department {
	
	@Id
	private Integer deptId;
	
	private String name;
	
	private String location;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private List<Employee> employees = new ArrayList<>();

}
