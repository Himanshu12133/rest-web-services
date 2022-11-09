package com.himanshu.spring.versioncontroller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.himanshu.spring.mediaobject.User;
import com.himanshu.spring.mediaobject.User2;

@RestController
public class VersionController {

	@RequestMapping(path = "/hello/v1", method = RequestMethod.GET)
	public User helloworld1() {
		return new User(0, "version1", LocalDate.now());
	}
	
	@GetMapping(path = "/hello/v2")
	public User2 helloworlAddingInURI() {
		return new User2(0, "version2", LocalDate.now(), 32);
	}

	@RequestMapping(path = "/hellover", method = RequestMethod.GET, params ="version=1")
	public User helloworldPassingParam() {
		return new User(0, "version1", LocalDate.now());
	}
	

	@RequestMapping(path = "/hellover", method = RequestMethod.GET, params ="version=2")
	public User2 helloworldPassingParam2() {
		return new User2(0, "version2", LocalDate.now(),32);
	}
	
	
	@RequestMapping(path = "/hellover", method = RequestMethod.GET, headers ="X-API-VERSION=1")
	public User helloworldPassingHeaders() {
		return new User(0, "version1", LocalDate.now());
	}
	

	@RequestMapping(path = "/hellover", method = RequestMethod.GET, headers ="X-API-VERSION=2")
	public User2 helloworldPassingHeaders2() {
		return new User2(0, "version2", LocalDate.now(),32);
	}

	
}
