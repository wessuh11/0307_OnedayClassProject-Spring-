package com.giltae.classbbs;
//DAO를 대체 자동으로 만들어줌. MyBatis가 자동으로 만들어짐.

import java.util.List;

import com.webjjang.board.vo.BoardVO;
import com.webjjang.util.PageObject;

public interface ClassDAO {
		
	//dao에서 작성한 메서드 형식으로 만들어준다.
	//interface만 만들어 두면 MyBatis 라이브러리에서 DAO를 대신 만들어 준다.
	//주고 받는 데이터 타입 정의, sql 문과 처리 명령문 필요하다. -> BoardMapper.xml, 
	
	// 1-1. 리스트														추상메서드
	public List<ClassVO> list(PageObject pageObject) throws Exception;
	// 1-2. 전체 데이터 개수
	public long getTotalRow(PageObject pageObject) throws Exception;
	// 2-1. 보기
	public ClassVO view(long no) throws Exception;
	// 2-2. 조회수 1증가
	public int increase(long no) throws Exception;
	// 3. 글쓰기
	public int write(ClassVO vo) throws Exception;
	// 4. 수정처리
	public int update(ClassVO vo) throws Exception;
	// 5. 삭제
	public int delete(long no) throws Exception;
}
