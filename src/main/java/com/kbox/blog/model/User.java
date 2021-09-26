package com.kbox.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // 빌더 패턴
@Entity // User 클래스가 Mysql에 테이블이 생성된다 // ORM -> 언어(ex) JAVA)  Object -> 테이블로 매핑해주는 기술
@DynamicInsert
public class User {
	
		@Id //Primary key
		@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
		private int id; // 시퀀스(오라클), auto_increment(mysql)
		
		@Column(nullable =false, length = 30)
		private String username; //아이디
		
		@Column(nullable =false, length = 100) // 해쉬 (비밀번호 암호화)
		private String password;
		
		@Column(nullable =false, length = 50)
		private String email;

		//@ColumnDefault("user")
		// DB는 RoleType이라는게 없다.
		@Enumerated(EnumType.STRING)
		private RoleType role;  // Enum을 쓰는게 좋다. // admin, user, manager
	
		@CreationTimestamp // 시간이 자동 입력
		private Timestamp createDate;
}
