package com.kbox.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kbox.blog.model.User;

// DAO
// 자동으로 bean등록이 된다.
// @Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer>{

}
