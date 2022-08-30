<%@page import="com.servlet.study.web.dto.test.User_dto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.servlet.study.web.dto.test.User_dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB-test-page</title>
</head>
<body>
	<%
		User_dao userdao = new User_dao();
		ArrayList<User_dto> dtos = userdao.USer_Select();
		
		for(int i = 0; i < dtos.size(); i++){
			User_dto dto = dtos.get(i);
			out.println(dto.getID());
			out.println(dto.getName());
			out.println(dto.getPassword());
			out.println(dto.getEmail());
		}
	%>
</body>
</html>