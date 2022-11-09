package com.himanshu.spring.userjparepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.himanshu.spring.mediaobject.User;

@Component
public interface UserJpaRepository extends JpaRepository<User, Integer>{

}
