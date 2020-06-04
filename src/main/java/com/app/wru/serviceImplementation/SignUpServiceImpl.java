package com.app.wru.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.wru.models.Customer;
import com.app.wru.repo.SignUpRepository;
import com.app.wru.service.SignUpService;
@Service
public class SignUpServiceImpl implements SignUpService{
	
	@Autowired
	private SignUpRepository signUpRepo;

	@Override
	public void addUser(Customer customerDetails) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Data "+customerDetails);
		signUpRepo.saveAndFlush(customerDetails);
		System.out.println("Data Saved");
		
	}
	
	

}
