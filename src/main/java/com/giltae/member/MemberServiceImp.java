package com.giltae.member;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	// 회원가입
	@Override
	public int signUp(Map<String, Object> map) {
		
		int affectRowCnt = 0;
		affectRowCnt = this.memberDAO.insert(map);

		return affectRowCnt;
	}
	
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
	
}
