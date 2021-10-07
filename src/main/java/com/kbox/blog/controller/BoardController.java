package com.kbox.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kbox.blog.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	// @AuthenticationPrincipal PrincipalDetail principal
	@GetMapping({"","/"})
	public String index(Model model, @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) { // 컨트롤러에서 세션을 어떻게 찾는지?
		model.addAttribute("boards", boardService.글목록(pageable));
		// /WEB-INF/views/index.jsp
		return "index"; // viewResolver 작동!!
	}
	
	// USER 권환이 필요
	@GetMapping("/board/saveForm")
	public String saveForm() {
		return "board/saveForm";
	}
}
