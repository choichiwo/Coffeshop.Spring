<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>login</title>
</head>
<body>

<form method="GET" action="/info">
	ID : <input type=text name=userid><br>
	주소 : <input type=text name=address><br>
	<input type=submit value="전송">
</form>
</body>
</html>