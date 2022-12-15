package org.example.controllers;

import org.example.models.User;
import org.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	private final UserRepository userRepository;

	@Autowired
	public HomeController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping(value="/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getUsers(){
		return ResponseEntity.ok(userRepository.findAll().toString());
	}

	@PostMapping(value="/users")
	public ResponseEntity<String> createUser(@RequestBody User user){
		userRepository.save(user);
		return new ResponseEntity<>("User created", HttpStatus.CREATED);
	}
}
