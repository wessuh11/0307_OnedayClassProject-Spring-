package pack.spring.basic;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
		
	public int insert(Map<String, Object> map) {		
		return this.sqlSessionTemplate.insert("sign.insert", map);
	}
	
	/*
	 * public Map<String, Object> selectDetail(Map<String, Object> map) { return
	 * this.sqlSessionTemplate.selectOne("sign.select_detail", map); }
	 * 
	 * public List<Map<String, Object>> selectList(Map<String, Object> map) { return
	 * this.sqlSessionTemplate.selectList("sign.select_list", map); }
	 */
}
