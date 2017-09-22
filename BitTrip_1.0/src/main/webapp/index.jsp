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
		<h1>${userName}��ȯ���մϴ�</h1>
		<a href="login.do">�α��� ����~</a><br>
		<a href="main.do">���� ����~</a>
		<h1>${myData}</h1>
		<hr>
		<table border=2>
			<tr>
				<td>���</td>
				<td>�̸�</td>
				<td>��</td>
				<td>�̸���</td>
				<td>��ȭ��ȣ</td>
				<td>�Ի���</td>
				<td>�޿�</td>
				<td>��</td>
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
					<td><a href="getPostInfo.do?post_id=${vo1.post_id}">����!</a>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>