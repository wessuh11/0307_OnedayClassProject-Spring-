//3. 컨트롤러와 DAO 연결 및 DAO에서 실행할 메서드 지정(인터페이스) -> 실체 메서드는 MemberServiceImp.java에서
//그래서 Map으로 호출한 
package com.giltae.member;

import java.util.Map;

public interface MemberService {
	// 인터페이스, 추상 클래스 역활 : 추상된 틀을 만들어 개발에 혼선이 없게끔 도와주는 역할을 하는 객체(다형성)
    // 인터페이스 : 인터페이스는 트리 구조와 같은 수직적 구조가 아닌 수평적 구조를 가지게 된다.
	// 추상클래스 : 추상 클래스는 트리 형식으로 상위 클래스와 하위 클래스로 나뉘어지는 트리 구조.
	
	// 회원가입
	int signUp(Map<String, Object> map);
	// 추상 메서드
	
	// 중복아이디 체크
	Map<String, Object> checkId(Map<String, Object> map);
	
	// 로그인
	Map<String, Object> login(Map<String, Object> map);
	
	// 로그아웃
	String logout();
	
	// 회원정보 수정 (회원 정보 확인)
	Map<String, Object> memberInfo(Map<String, Object> map);
	
	// 회원정보 수정
	int memberMod(Map<String, Object> map);
	
	// 회원 탈퇴
	int deleteMember(Map<String, Object> map);
	
}
