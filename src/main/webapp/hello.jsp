<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%!
    //선언식 %!
    	String name = null;
    %>
    <%
    //스크립트릿 %
    List<String> nameList = new ArrayList<String>();
    nameList.add("김준일");
    nameList.add("조문기");
    nameList.add("박소영");
    nameList.add("서재효");
    nameList.add("신승한");
    nameList.add("이승환");
    nameList.add("최연호");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table, th, td{
border: 1px solid black;
border-collapse: collapse;
text-align: center;
}
table{
width: 150px;
}
</style>
</head>
<body>
<table>
	<tr>
		<th>번호</th>
		<th>이름</th>
	</tr>
<%
	for(int i = 0; i < nameList.size(); i++){
	name = nameList.get(i);
%>
		<tr>
		<td><%=i + 1 %></td>
		<td><%=name %></td>
		</tr>
<%
		}
%>
		
	
</table>
</body>
</html>