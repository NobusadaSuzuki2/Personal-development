<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/original/common.css">
<link rel="stylesheet" href="css/original/header.css">
<jsp:include page="/baselayout/head.html" />
</head>
<header>
	<jsp:include page="/baselayout/header.jsp" />
</header>

<body style="background-color: #e9ecef75;">
	<div class="top-wrapper">
		<div class="container">
			<c:if test="${errMsg != null}">
				<div class="alert alert-danger" role="alert">${errMsg}</div>
			</c:if>
			<h1>ユーザー新規登録</h1>
			<H1></H1>
			<form class="form-signup" action="signupServlet" method="post">
				<h3>
					<input type="text" name="loginId" placeholder="ログインID">
				</h3>
				<h3>
					<input type="text" name="password" placeholder="パスワード">
				</h3>
				<h3>
					<input type="text" name="password2" placeholder="パスワード（確認）">
				</h3>
				<h3>
					<input type="text" name="user_name" placeholder="ユーザー名">
				</h3>
				<h3>
					<input type="text" name="address" size="50" placeholder="住所">
				</h3>
				<div class="btn-wrapper">
					<button class="btn btn-primary" type="submit">登録</button>
				</div>
			</form>
		</div>
	</div>


</body>
</html>