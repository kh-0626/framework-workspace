package com.kh.spring.ajex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring.board.model.dto.BoardDTO;
import com.kh.spring.board.model.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AjaxController {
	
	@GetMapping("ajax")
	public String forward() {
		return "ajax/ajax";
	}
	
	@ResponseBody
	@GetMapping(value = "test", produces="text/html; charset=UTF-8")
	public String ajaxReturn(@RequestParam(name="input") String value) {
		log.info("AJAX요청을 통해 넘어온 VALUE값 : {}", value);
		
		String returnValue = value.equals("admin") ? "아이디 있어요" : "아이디 있어요";
		
		return returnValue;
	}
	
	private final BoardService boardService;
	
	@Autowired
	public AjaxController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@ResponseBody
	@GetMapping(value = "study", produces="application/json; charset=UTF-8")
	public BoardDTO ajaxStudy(@RequestParam("replyNo") int boardNo) {
		
		/*
		 * DTO의 목적 == 테이블의 행에 있는 컬럼의 값을 필드에 담아옴
		 * 
		 * BOARDDTO
		 * 
		 * boardTitle == 머시기
		 * boardContent == 머시기
		 * boardWriter == 머시기
		 * {
		 * 	"boardTitle" : "제목",
		 * 	"boardContent" : "내용"
		 * }
		 */
		//BoardDTO board = 
		/*
		log.info("{}", board);
		*/
		
		return boardService.selectBoard(boardNo);
	}
	
	
}
