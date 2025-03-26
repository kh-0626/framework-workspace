package com.kh.spring.exception.controller;

import java.security.InvalidParameterException;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.kh.spring.exception.AuthenticationException;
import com.kh.spring.exception.DuplicateIdException;
import com.kh.spring.exception.TooLargeValueException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlingController {

	private ModelAndView createErrorResponse(String errorMsg, Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", e.getMessage())
			.setViewName("include/error_page");
		log.info("발생예외 : {} ", errorMsg, e);
		return mv;
	}
	
	@ExceptionHandler(AuthenticationException.class)
	protected ModelAndView authenticationException(AuthenticationException e) {
		return createErrorResponse(e.getMessage(), e);
	}
	
	@ExceptionHandler(DuplicateIdException.class)
	protected ModelAndView DuplicateIdException(DuplicateIdException e) {
		return createErrorResponse(e.getMessage(), e);
	}
	
	@ExceptionHandler(PasswordNotMatchException.class)
	protected ModelAndView PasswordNotMatchException(PasswordNotMatchException e) {
		return createErrorResponse(e.getMessage(), e);
	}
	
	@ExceptionHandler(MemberNotFoundException.class)
	protected ModelAndView idNotFoundException(MemberNotFoundException e) {
		return createErrorResponse(e.getMessage(), e);
	}
	
	@ExceptionHandler(InvalidParameterException.class)
	protected ModelAndView invaliParameterError(InvalidParameterException e) {
		return createErrorResponse(e.getMessage(), e);
	}
	
	@ExceptionHandler(TooLargeValueException.class)
	protected ModelAndView tooLargeValueException(TooLargeValueException e) {
		return createErrorResponse(e.getMessage(), e);
	}
	
	/*
	@ExceptionHandler(InvalidParameterException.class)
	protected ModelAndView invaliParameterError(InvalidParameterException e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", e.getMessage())
			.setViewName("include/error_page");
		return mv;
	}
	
	@ExceptionHandler(RuntimeException.class)
	protected ModelAndView runTimeError(RuntimeException e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "아이디가 너무 길어용...")
			.setViewName("include/error_page");
		return mv;
	}
	*/
}
