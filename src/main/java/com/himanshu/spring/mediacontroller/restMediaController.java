package com.himanshu.spring.mediacontroller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.himanshu.spring.mediaobject.User;
import com.himanshu.spring.mediaservice.RestMediaService;

import jakarta.validation.Valid;

@RestController
public class restMediaController {

	@Autowired
	RestMediaService restMediaService;

	@GetMapping(path = "/users")
	public List<User> getAllUsers() {
		return restMediaService.getAllUsers();
	}

	@GetMapping(path = "/users/{id}")
	public User getUser(@PathVariable int id) {
		return restMediaService.getUser(id);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User saved = restMediaService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	
	@DeleteMapping("/users/{id}")
	public void deleteUserUser(@PathVariable int id) {
		 restMediaService.deleteUser(id);
		
	}
		

}
