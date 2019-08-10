            
            근본적인 해결 방법은 커넥션 풀을 사용하는 방법이나
            아직 커넥션 풀을 설정하지 않았으므로 오라클 서버의 세션수를 늘려서 문제를 해결하기로 함.
            
            alter system set processes=2000 scope=spfile;
            
            alter system set sessions=2492 scope=spfile;
            
            show parameter sessions
            
            show parameter processes