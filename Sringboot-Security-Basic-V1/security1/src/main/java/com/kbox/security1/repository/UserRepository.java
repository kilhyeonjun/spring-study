package com.kbox.security1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kbox.security1.model.User;

// CRUD 함수를 JpaRepository가 들고 있음
// @Repository라는 어노테이션이 없어도 IoC가 됨. JpaRepository를 상속 했기 때문
public interface UserRepository extends JpaRepository<User, Integer>{

	// findeBy규칙 -> Username문법
	// select * from user where username = 1?
	public User findByUsername(String username); // Jpa Query methods
	
}
