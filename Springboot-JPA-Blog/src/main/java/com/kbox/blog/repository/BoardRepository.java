package com.kbox.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kbox.blog.model.Board;

// DAO
// 자동으로 bean등록이 된다.
// @Repository 생략 가능
public interface BoardRepository extends JpaRepository<Board, Integer>{

}
