package com.app.service;

import java.util.List;

import com.app.dto.PolicyDto;
import com.app.entities.Policy;

public interface IPolicyService {
	
	
	Policy addNewPolicy(Policy newPolicy);
	List<Policy> getAllPolicys();
	Policy getPolicyById(Long Id);
	String deletePolicyDetails(Long PolicyID);
	Policy updatePolicy(Policy updatedPolicy);
	Policy addStudent(PolicyDto stud);

}
