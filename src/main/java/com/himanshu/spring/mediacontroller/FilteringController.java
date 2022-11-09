package com.himanshu.spring.mediacontroller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.himanshu.spring.mediaobject.User2;
import com.himanshu.spring.mediaservice.RestMediaService;

@RestController
public class FilteringController {
	@Autowired
	RestMediaService restMediaService;

	@RequestMapping(path = "/hellofilteringstatic", method = RequestMethod.GET)
	public User2 hellofilteringstatic() {
		return new User2(0, "version2", LocalDate.now(), 32);
	}

	@GetMapping(path = "/hellofilteringdynamic")
	public MappingJacksonValue hellofilteringdynamic() {
		User2 user = new User2(0, "version2", LocalDate.now(), 32);
		MappingJacksonValue mv = new MappingJacksonValue(user);

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "age");
		FilterProvider filters = new SimpleFilterProvider().addFilter("filteridandage", filter);

		mv.setFilters(filters);
		return mv;
	}

}
