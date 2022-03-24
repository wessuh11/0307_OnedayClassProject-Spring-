package spring.basic.odc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public String signUp(Map<String, Object> map) {
		
		int affectRowCnt = this.memberDAO.insert(map);
		if (affectRowCnt == 1) {
					return map.get("member_id").toString();
		}
		return null;
	}
	
	@Override
	public Map<String, Object> checkId(Map<String, Object> map) {
		
		return this.memberDAO.selectCheckId(map);
	}
	
	/*
	 * @Override public String index() { return null; }
	 */
}
