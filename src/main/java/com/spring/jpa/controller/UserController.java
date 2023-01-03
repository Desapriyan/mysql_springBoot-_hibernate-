package com.spring.jpa.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.jpa.service.DemoUserService;
import com.spring.jpa.user.DemoUser;


@RestController
@RequestMapping("/DemoUser")
public class UserController {

	@Autowired
	private DemoUserService demoUserService;

	@PostMapping(value = "/create")
	public ResponseEntity<DemoUser> createUser(@RequestBody DemoUser user) {
		demoUserService.save(user);
		return ResponseEntity.ok(user);
	}
	@GetMapping(value = "/get-all")
	public List<DemoUser> getAllUsers() { 
		return demoUserService.getAll();
}
	
	@GetMapping(value = "/get/{id}")
	public DemoUser getByID(@PathVariable("id") UUID id) { 
		
		Optional<DemoUser> userOptional = demoUserService.getByID(id);
	
		return userOptional.get();
}
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<UUID> deleteUser(@PathVariable UUID id) {
		demoUserService.deleteUser(id);
		return ResponseEntity.ok(null);
	
}
	
	@PutMapping(value = "/update")
	public ResponseEntity<DemoUser> updateUser(@RequestBody DemoUser user) {
		demoUserService.updateUser(user);
		return ResponseEntity.ok(user);
	
}
}