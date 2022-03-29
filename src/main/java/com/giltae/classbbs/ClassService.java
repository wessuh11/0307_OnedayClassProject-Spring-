package com.giltae.classbbs;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.webjjang.board.mapper.BoardMapper;
import com.webjjang.board.vo.BoardVO;
import com.webjjang.util.PageObject;


// @Controller, @Service, @Repository, @Component, @RestController
// -> root-context.xml, servlet-content.xml에 scan 패키지 안쪽에 존재
@Service
public class ClassService {
	
	@Inject
	private ClassDAO mapper;
	
	public List<ClassVO> list(PageObject pageObject) throws Exception{
		// 전체 데이터 개수 가져오기는 처리를 해야 시작 줄과 끝줄이 계산이 된다.
		pageObject.setTotalRow(mapper.getTotalRow(pageObject));
		System.out.println("BoardService.list().pageObject - " + pageObject);
		return mapper.list(pageObject);
	}

}
