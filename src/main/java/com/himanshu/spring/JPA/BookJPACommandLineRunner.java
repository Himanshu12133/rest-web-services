package com.himanshu.spring.JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.himanshu.spring.JPA.objects.Book;

@Component
public class BookJPACommandLineRunner implements CommandLineRunner {

	@Autowired
	BookJPARepository repository;

	@Override
	public void run(String... args) throws Exception {

		Book book1 = new Book(1, "Head First", "Java1");
		Book book2 = new Book(2, "Head two", "Java2");
		Book book3 = new Book(3, "Head three", "Java3");

		repository.insert(book1);
		repository.insert(book2);

		repository.insert(book3);

		repository.deletebyID(2);

		Book book = repository.findbyID(1);
		System.out.println(book.getAuthor() + "temper");

	}
}
