//2. Mapper의 DML 중에서 실행해야 하는 구문을 메서드로 지정하여 실행!
package com.giltae.member;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
//해당 클래스를 루트 컨테이너에 빈(Bean) 객체로 생성해주는 어노테이션입니다, 패키지는 DB에 접근하는 모든 코드가 모여있다고 생각하셈

public class MemberDAO {
	@Autowired
	//필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입한다.(생성자, setter, 필드)
	
	SqlSessionTemplate sqlSessionTemplate;
	// Mybatis 쿼리문을 수행해주는 역활..
	// DAO 클래스에 직접 SqlSession 객체를 선언하고 @Autowired으로 의존주입하여 쿼리문을 수행함
	// root-context.xml에 sqlSessionFactory를 등록해야 함!!

	// Map은 선언 시 <key, value>로 값을 넣는다.
	// Key와 Value는 한 쌍으로, Key로 식별하고 Value에 사용할 값을 넣는 식이다
	
	
	public int insert(Map<String, Object> map) {
	// insert라는 메서드에 (Map<String, Object> map <-- 파라미터) 에 담아 return을 통해 다른곳에서 사용할때 값을 받아넘겨줌.
		return this.sqlSessionTemplate.insert("sign.insert", map);
	}//                                                           mappler id..
	// mapper의 insert 메서드 : 값 추가
	//	insert into memberList (uId, uPw, uName, uPhone, uZip, uAddr1, uAddr2, uEmail)
	//	values 
	//	(#{uId}, #{uPw}, #{uName}, #{uPhone}, #{uZip}, #{uAddr1}, #{uAddr2}, #{uEmail})

	public Map<String, Object> selectCheckId(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("sign.select_checkId", map);
	}
	//mapper의 select_checkId 메서드 : 값 비교
	//select uId from memberList where uId = #{uId}
	
	public Map<String,Object> selectLogin(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("sign.select_login", map);
	}
	// mapper의 select_login 메서드
	
	public Map<String, Object> selectMemberInfo(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("sign.select_memberMod", map);
	}
	// mapper의 select_memberMod 메서드
	
	public int updateMember(Map<String, Object> map) {
		return this.sqlSessionTemplate.update("sign.update_memberMod", map);
	}
	// mapper의 update_memberMod 메서드
	
	public int deleteMember(Map<String, Object> map) {
		return this.sqlSessionTemplate.delete("sign.delete_member", map);
	}
	// mapper의 delete_member 메서드
	
}
