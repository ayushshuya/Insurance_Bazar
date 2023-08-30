package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PolicyDto;
import com.app.entities.Policy;
import com.app.service.IPolicyService;

@RestController
@RequestMapping("/policy")
@CrossOrigin(origins = "http://localhost:3000")

public class PolicyController {

	
	@Autowired
	private IPolicyService Policyservice;
	
	@GetMapping
	public List<Policy> getAllPolicys(){
		return Policyservice.getAllPolicys();
	}
	
	@GetMapping("/{vid}")
	public Policy getPolicyById(@PathVariable Long vid) {
		return Policyservice.getPolicyById(vid);
	}
	
//	@PostMapping
//	public Policy addPolicy(@RequestBody Policy newPolicy) {
//		return Policyservice.addNewPolicy(newPolicy);
//	}
	
	@DeleteMapping("/{vid}")
	public String deletePolicy(@PathVariable Long vid) {
		return Policyservice.deletePolicyDetails(vid);
	}
	
	@PutMapping
	public Policy updatePolicy(@RequestBody @Valid Policy updPolicy) {
		return Policyservice.updatePolicy(updPolicy);
	}
	
	@PostMapping("/add")
	public Policy addStudent(@RequestBody PolicyDto stud) {
		return Policyservice.addStudent(stud);
	}
	
	
	
	
}
