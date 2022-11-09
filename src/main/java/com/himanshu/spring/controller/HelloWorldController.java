package com.himanshu.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.himanshu.spring.objects.*;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(path = "/hello", method = RequestMethod.GET)
	public String helloworld() {
		return "Hello World";
	}

	@GetMapping(path = "/hellobean/{name}")
	public helloworldbean helloworldbean(@PathVariable String name) {
		return new helloworldbean(name);
	}

	@GetMapping(path = "/hellogetmapping")
	public String helloworldGetMapping() {
		return "Hello World Get Mapping";
	}

	@GetMapping(path = "/hellogetmapping/{name}")
	public String helloworldpathvariable(@PathVariable String name) {
		return "Hello World Get Mapping " + name;
	}
	@RequestMapping(path = "/helloInternationlized", method = RequestMethod.GET)
	public String helloInternationlized() {
		return messageSource.getMessage("good.morning.message", null, null, LocaleContextHolder.getLocale());
	}
}
