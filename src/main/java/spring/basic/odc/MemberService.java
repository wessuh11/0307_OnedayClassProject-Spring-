package spring.basic.odc;

import java.util.Map;

public interface MemberService {

	String signUp(Map<String, Object> map);
	
	Map<String, Object> checkId(Map<String, Object> map);
	
//	String index( );
}
