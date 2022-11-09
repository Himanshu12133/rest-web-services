package com.himanshu.spring.jpacontroller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.himanshu.spring.exception.UserNotFoundException;
import com.himanshu.spring.mediaobject.Post;
import com.himanshu.spring.mediaobject.User;
import com.himanshu.spring.userjparepository.PostJPARepository;
import com.himanshu.spring.userjparepository.UserJpaRepository;

import jakarta.validation.Valid;

@RestController
public class restMediaJPAController {
	@Autowired
	UserJpaRepository userrepository;
	@Autowired
	PostJPARepository postJPARepository;

	@GetMapping(path = "/jpa/users")
	public List<User> getAllUsers() {
		return userrepository.findAll();
	}

	@GetMapping(path = "/jpa/users/{id}")
	public User getUser(@PathVariable int id) {
		Optional<User> user = userrepository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("User does not exist");
		}
		return user.get();
	}

	@RequestMapping(method = RequestMethod.POST, path = "/jpa/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User saved = userrepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@RequestMapping(method = RequestMethod.POST, path = "/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForuser(@PathVariable int id, @Valid @RequestBody Post post) {
		Optional<User> user = userrepository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("User does not exist");
		}
		post.setUser(user.get());
		Post postSaved =  postJPARepository.save(post);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(postSaved.getId())
				.toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/jpa/users/{id}")
	public void deleteUserUser(@PathVariable int id) {
		userrepository.deleteById(id);

	}

	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePostsForUser(@PathVariable int id) {
		Optional<User> user = userrepository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("User does not exist");
		}
		System.out.println(user.get().getPosts());
		return user.get().getPosts()
;
	}
}
