package com.himanshu.spring.mediacontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.himanshu.spring.mediaobject.User;
import com.himanshu.spring.mediaservice.RestMediaService;

@RestController
public class hateOSController {

	@Autowired
	RestMediaService restMediaService;

	@GetMapping(path = "/userswithlink")
	public List<User> getAllUsersH() {
		return restMediaService.getAllUsers();
	}

	@GetMapping(path = "/userswithlink/{id}")
	public EntityModel<User> getUsersWithLink(@PathVariable int id) {
		EntityModel<User> en = EntityModel.of(restMediaService.getUser(id));

		WebMvcLinkBuilder wmvc = linkTo(methodOn(this.getClass()). getAllUsersH());
		en.add(wmvc.withRel("temp-url"));
		return en;
	}
}
