package com.himanshu.spring.JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.himanshu.spring.JPA.objects.Book;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

//NO need of query map entities directly

@Repository
@Transactional
public class BookJPARepository {

	@Autowired
	private EntityManager entityManager;

	public void insert(Book book) {
		entityManager.merge(book);

	}

	public void deletebyID(int id) {
		Book book = findbyID(id);
		entityManager.remove(book);
	}

	public Book findbyID(int id) {
		return entityManager.find(Book.class, id);
	}
}
