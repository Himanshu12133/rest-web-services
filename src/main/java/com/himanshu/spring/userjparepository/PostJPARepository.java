package com.himanshu.spring.userjparepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.himanshu.spring.mediaobject.Post;

public interface PostJPARepository  extends JpaRepository<Post, Integer>{

}
