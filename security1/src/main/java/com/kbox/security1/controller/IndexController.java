package com.kbox.security1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kbox.security1.model.User;
import com.kbox.security1.repository.UserRepository;

@Controller // View를 리턴하겠다
public class IndexController {
	
	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
	
	// localhost:8080/
	// localhost:8080
	@GetMapping({"","/"})
	public String index() {
		// 머스태치 기본폴더 src/main/resources/
		// viewReslover 설정 : templates (prefix), .mustach(suffix) 생략 가능
		return "index"; // src/main/resources/templates/index.mustach
	}
	
	@GetMapping("/user")
	public @ResponseBody String user() {
		return "user";
	}
	
	@GetMapping("/admin")
	public @ResponseBody String admin() {
		return "admin";
	}
	
	@GetMapping("/manager")
	public@ResponseBody String manager() {
		return "manager";
	}
	
	// 스프링시큐리티 해당주소를 낚아챔 - SecurityConfig 파일 생성 후 작동안함.
	@GetMapping("/loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "joinForm";
	}
	
	@PostMapping("/join")
	public String join(User user) {
		user.setRole("ROLE_USER");
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		userRepository.save(user); // 회원가입 잘됨. 비밀번호 : 1234 => 시큐리티로 로그인을 할 수 없음. 패스워드가 암호화가 안되었기 때문
		return "redirect:/loginForm";
	}
	
	@GetMapping("/joinProc")
	public @ResponseBody String joinProc() {
		return "회원가입 완료 됨";
	}
	
}
