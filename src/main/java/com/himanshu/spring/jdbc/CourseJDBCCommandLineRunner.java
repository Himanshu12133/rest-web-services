package com.himanshu.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.himanshu.spring.jdbc.objects.Course;

//to execute JDBC at project startup
@Component
public class CourseJDBCCommandLineRunner implements CommandLineRunner {

	@Autowired
	CourseJDBCRepository repository;

	@Override
	public void run(String... args) throws Exception {
		repository.insert(new Course(1, "Himanshu", "Mittal"));
		repository.insert(new Course(2, "Nikhil", "Mittal"));
		repository.insert(new Course(3, "Richa", "Sahni"));

		repository.deletebyID(2);

		Course course = repository.selectbyID(1);
		System.out.println(course.getAuthor()+"temper");

	}

}
