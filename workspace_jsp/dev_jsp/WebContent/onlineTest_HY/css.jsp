<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../common/JEasyUICommon.jsp" %>
<script>
	$(document).ready(function(){
		$("#center").hide();
	});
	function 
		$.ajax(){
			
		}

</script>
</head>
<body>
<div id='center'>
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
                <a id='m_js' href="#c_js"   title="JS로 갈거야?" class="easyui-tooltip">javaScript</a>
            </div>
            
            
     <!--============================ 왼쪽 패널     ================================= -->           
     <!--============================ 중앙 패널     ================================= -->
     	 <div id='center' data-options="region:'center'">
            <div id='c_css' data-options="region:'center'" style="padding:10px">
                <div class="easyui-tabs" data-options="fit:true,border:false,plain:true">
                 	<div title="History" data-options="fit:true,border:false,plain:true" style="padding:10px">
                 		<div> Historysdafsdfsadfiosadfoisadjf
                 		</div>
                 	</div>
                 	<div title="Example" data-options="fit:true,border:false,plain:true" style="padding:10px">
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
</div>
</body>
</html>