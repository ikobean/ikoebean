package onlineTest;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mybatis.TestDao;

public class TestLogic {
	Logger logger = Logger.getLogger(TestLogic.class);
	TestDao testDao  = new TestDao();
	public List<Map<String,Object>> subjectList(){
		logger.info("subjectList 호출 성공");
		List<Map<String,Object>> subList = null;
		subList = testDao.subjectList();
		return subList;
	}
	
}
