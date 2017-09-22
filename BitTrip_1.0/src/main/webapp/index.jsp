<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Main Page!!</title>
</head>
<body>
	<center>
		<h1>${userName}님환영합니다</h1>
		<a href="login.do">로그인 가자~</a><br>
		<a href="main.do">메인 가자~</a>
		<h1>${myData}</h1>
		<hr>
		<table border=2>
			<tr>
				<td>사번</td>
				<td>이름</td>
				<td>성</td>
				<td>이메일</td>
				<td>전화번호</td>
				<td>입사일</td>
				<td>급여</td>
				<td>상세</td>
			</tr>
			<c:forEach var="vo1" items="${post}">
				<tr>
					<td>${vo1.post_id}</td>
					<td>${vo1.user_id}</td>
					<td>${vo1.name}</td>
					<td>${vo1.title}</td>
					<td>${vo1.trip_date}</td>
					<td><fmt:formatDate value="${vo1.create_date}"
							pattern="yyyy-MM-dd" /></td>
					<td>${vo1.country}</td>
					<td><a href="getPostInfo.do?post_id=${vo1.post_id}">가자!</a>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>