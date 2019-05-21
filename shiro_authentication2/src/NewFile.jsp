<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://shiro.apache.org/tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
<base href="<%=basePath%>">    
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:hasPermission name="user:update">
		<a href="#">更新</a>
	</s:hasPermission>
</body>
</html>