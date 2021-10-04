package com.kbox.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kbox.blog.config.auth.PrincipalDetail;

@Controller
public class BoardController {

	// @AuthenticationPrincipal PrincipalDetail principal
	@GetMapping({"","/"})
	public String index() { // 컨트롤러에서 세션을 어떻게 찾는지?
		// /WEB-INF/views/index.jsp
		return "index";
	}
	
	// USER 권환이 필요
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
}
