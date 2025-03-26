package com.kh.spring.model.service;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Service;

import com.kh.spring.model.dto.MemberDTO;

@Service
public interface MemberService {
	
	// 로그인
	MemberDTO login(MemberDTO member);
	
	// 회원가입
	// 좋은방법 : 가입된 회원의 정보를 반환해준다
	// 일반적인방법 : 정수값을 반환하거나 값을 반환하지 않는다. (MyBatis)
	void signUp(MemberDTO member);
	
	// 회원정보수정
	//int update(MemberDTO member, HttpSession session); // 1번
	void update(MemberDTO member, HttpSession session); // 2번
	
	// 회원탈퇴
	int delete(MemberDTO member);
	
	// 1장 끝
	
	
	// 아이디 중복체크

	String idCheck(String memberId);
	
	// 이메일인증....시간없는데..가능???가능함??? 가능하면함 시간되면함
	
}
