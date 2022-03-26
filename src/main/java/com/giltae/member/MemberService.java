package com.giltae.member;

import java.util.Map;

public interface MemberService {
	
	// 회원가입
	int signUp(Map<String, Object> map);
	
	// 중복아이디 체크
	Map<String, Object> checkId(Map<String, Object> map);
	
	// 로그인
	Map<String, Object> login(Map<String, Object> map);
	
}
