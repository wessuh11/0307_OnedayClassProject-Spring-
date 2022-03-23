package pack.spring.basic;

import java.util.List;
import java.util.Map;

public interface MemberService {

	String member(Map<String, Object> map);
	// 글입력양식 페이지 및 데이터 입력처리
	
	/*
	 * Map<String, Object> detail(Map<String, Object> map); // 글내용 상세보기 뷰페이지( MVC의
	 * View 아님! )
	 * 
	 * List<Map<String, Object>> list(Map<String, Object> map); // 전체 글보기
	 */ 	
 	String index( );
 	// 메인페이지(=인덱스 페이지)

}
