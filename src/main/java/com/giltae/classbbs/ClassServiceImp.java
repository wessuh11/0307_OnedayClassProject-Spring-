package com.giltae.classbbs;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// 해당 클래스를 루트 컨테이너에 빈(Bean) 객체로 생성해주는 어노테이션입니다.
// DB에 접근하는 코드는 repository에 위임하고, 비즈니스 로직과 관련된 모든 코드가 모여있음.

public class ClassServiceImp implements MemberService {
					//구현클래스명                                    인터페이스명

	@Autowired
	//필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입한다.(생성자, setter, 필드)
	MemberDAO memberDAO;
	
	
	// 회원가입
	@Override
	public int signUp(Map<String, Object> map) {
		
		int affectRowCnt = 0;
		affectRowCnt = this.memberDAO.insert(map);

		return affectRowCnt;
	}
	//인터페이스에 구현된 실체 메서드 실행
	
	// 중복아이디 체크
	@Override
	public Map<String, Object> checkId(Map<String, Object> map) {
		
		return this.memberDAO.selectCheckId(map);
	}
	
	// 로그인
	@Override
	public Map<String, Object> login(Map<String, Object> map) {
		
		return this.memberDAO.selectLogin(map);
	}
	
	// 로그아웃
	@Override
	public String logout() {
		return null;
	}
	
	// 회원정보 확인
	@Override
	public Map<String, Object> memberInfo(Map<String, Object> map) {
		return this.memberDAO.selectMemberInfo(map);
	}
	
	// 회원정보 수정
	@Override
	public int memberMod(Map<String, Object> map) {
		
		int affectRowCnt = 0;
		
		affectRowCnt = this.memberDAO.updateMember(map);
		
		return affectRowCnt;
	}
	
	// 회원 탈퇴
	@Override
	public int deleteMember(Map<String, Object> map) {

		int affectRowCnt = 0;
		
		affectRowCnt = this.memberDAO.deleteMember(map);
		
		return affectRowCnt;
	}
	
}
