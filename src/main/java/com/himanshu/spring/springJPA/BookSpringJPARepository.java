package com.himanshu.spring.springJPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.himanshu.spring.JPA.objects.Book;

public interface BookSpringJPARepository extends JpaRepository<Book, Integer> {

	public List<Book> findByAuthor(String author);

}
