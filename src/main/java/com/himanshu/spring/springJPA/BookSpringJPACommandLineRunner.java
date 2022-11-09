package com.himanshu.spring.springJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.himanshu.spring.JPA.objects.Book;

@Component
public class BookSpringJPACommandLineRunner implements CommandLineRunner {

	@Autowired
	BookSpringJPARepository repository;

	@Override
	public void run(String... args) throws Exception {

		Book book1 = new Book(1, "Head Spring  First", "Java1 Spring");
		Book book2 = new Book(2, "Head Spring two", "Java2 Spring");
		Book book3 = new Book(3, "Head Spring three", "Java3 Spring");

		repository.save(book1);
		repository.save(book2);

		repository.save(book3);

		repository.deleteById(2);

		System.out.println(repository.findById(1));
		// add function with same varaible name
		System.out.println(repository.findByAuthor("Java3 Spring"));

	}
}
