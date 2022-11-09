package com.himanshu.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.himanshu.spring.jdbc.objects.Course;

@Repository
public class CourseJDBCRepository {

	@Autowired
	private JdbcTemplate springJdbcTemplate;

	private String INSERT_QUERY = """
			insert into course(id,name,author)
			values(?,? ,?);
			""";

	private String DELETE_QUERY = """
			delete from course
			where id =?
			""";

	private String SELECT_QUERY = """
			select * from course
			where id =?
			""";

	public void insert(Course course) {
		springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());

	}

	public void deletebyID(int id) {
		springJdbcTemplate.update(DELETE_QUERY, id);
	}

	public Course selectbyID(int id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
	}
}
