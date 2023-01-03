package com.spring.jpa.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.jpa.repository.DemoUserRepository;
import com.spring.jpa.user.DemoUser;


@Service
public class DemoUserService {

	@Autowired
	private  DemoUserRepository demoUserRepository;

	public  void save(DemoUser user) {
		demoUserRepository.save(user);
	}

	public List<DemoUser> getAll() {
		
		return (List<DemoUser>) demoUserRepository.findAll();
	}

	public Optional<DemoUser> getByID(UUID id) {
		
		return demoUserRepository.findById(id);
	}

	public void deleteUser(UUID id) {
		
		demoUserRepository.deleteById(id);
	}

	public void updateUser(DemoUser user) {
		demoUserRepository.save(user);
		
	}


	}


