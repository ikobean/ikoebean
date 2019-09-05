<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../common/JEasyUICommon.jsp" %>
<title>자바 스크립트 노트 페이지</title>
<script>
	$(document).ready(function(){
		$("#center").hide();
	});


	function c_change(){
		$.ajax(){
			
		}

	}
	
</script>
</head>
<body>

<h2>Front-End 노트</h2>
    <p>자바 스크립트를 알아보자</p>
    <div style="margin:20px 0 10px 0;"></div>
    <!--============================ 큰 틀 부분    ================================= -->
    <div class="easyui-panel" title="JavaScript" style="width:1000px;height:700px;padding:10px;">
        <div class="easyui-layout" data-options="fit:true">
    <!--============================ 왼쪽 패널     ================================= -->
            <div data-options="region:'west',split:true" style="width:100px;padding:10px">
                <a id='m_html' href="./html.jsp"  title="html로 갈거야?" class="easyui-tooltip">html</a> <br><br>
                <a id='m_css' href="./css.jsp"  title="CSS로 갈거야?" class="easyui-tooltip">CSS</a><br><br>
                <a id='m_js' href="/jsp.jsp"   title="JS로 갈거야?" class="easyui-tooltip">javaScript</a>
            </div>
            
            
     <!--============================ 왼쪽 패널     ================================= -->           
     <!--============================ 중앙 패널     ================================= -->
     	 <div id='center' data-options="region:'center'">
            <div id='c_js' data-options="region:'center'" style="padding:10px">
                <div class="easyui-tabs" data-options="fit:true,border:false,plain:true">
	                 <div title="History" data-options="fit:true,border:false,plain:true" style="padding:10px">
	                  History
	                 </div>
	                 <div title="Example" style="padding:5px">
	            	  example
	            	</div>
            	</div>
            </div>
        </div>   
     <!--============================ 중앙 패널  끝   ================================= -->   
            <div data-options="region:'east'" style="width:100px;padding:10px">
                Right Content
            </div>
    <!--============================ 큰 틀 부분    ================================= -->
        </div>
    </div>
</body>
</html>