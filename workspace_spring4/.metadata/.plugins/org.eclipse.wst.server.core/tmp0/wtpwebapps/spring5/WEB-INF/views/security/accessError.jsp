<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Access Error Page</title>
</head>
<body>
<h1>Access Denied</h1>
<h2><c:out value="${SPRING_SECURITY_403EXCEPTION.getMessage()}"/></h2>
<h2><c:out value="${msg}"/></h2>
</body>
</html>