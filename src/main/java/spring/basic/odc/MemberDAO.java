package spring.basic.odc;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int insert(Map<String, Object> map) {
				return this.sqlSessionTemplate.insert("sign.insert", map);
	}
	
	public Map<String, Object> selectCheckId(Map<String, Object> map) {
		return this.sqlSessionTemplate.selectOne("sign.select_checkId", map);
	}
}
