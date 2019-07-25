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
	public int examReceipt(Map<String, Object> pMap) {
		logger.info("examReceipt 로직 호출 성공");
		int result = 0;
		String exam_no = "0"; //수험번호 채번하여 담기
		exam_no =testDao.getExamNo();//select 건
		logger.info("exam_no: "+exam_no);
		//위에서 채번한 수험번호를 파라미터에 넣기
		pMap.put("exam_no", exam_no);
		//시험 응시 접수 처리 - insert 건
		//0이면 점수 실패, 1이면 접수 성공
		result = testDao.examReceipt(pMap);//위에서 수험번호가 담겼으므로 호출 가능
		return result;
	}

	
}
