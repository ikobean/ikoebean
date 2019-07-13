rowid

SELECT rowid rid FROM EMP

6자리 : 데이터에 대한 오브젝트 번호
3자리 : 상대적 파일번호
3자리 : 블록번호
3자리 : 블록 내의 행번호

SELECT ENAME, HIREDATE 
 FROM EMP
 WHERE ROWID = 'AAARE8AAEAAAACTAAA'
 
 ROWID:DBMS가 가지고 있는 모든 데이터의 각각의 고유한 식별자
 
 이 ROWID는 index와도 관련이 있는데 index 테이블은 index key와
 rowid로 이루어져있기 때문이다.
 이렇게 저장공간을 가지고 있는 rowid는 마치 물리적인 정보라고 생각할 수 있지만
 실제로는 존재하지 않으며 index 테이블 내에 있는 rowid는 해당데이터를 찾기 위한 
 하나의 논리적인 정보일 뿐이다.
 
 
