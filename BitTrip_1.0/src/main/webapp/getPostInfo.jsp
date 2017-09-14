<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
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
			
				<tr>
					<td>${postInfo.post_id}</td>
					<td>${postInfo.name}</td>
					<td>${postInfo.title}</td>
					<td>${postInfo.content }</td>
					<td>${postInfo.location }</td>
				</tr>

		</table>
</body>
</html>