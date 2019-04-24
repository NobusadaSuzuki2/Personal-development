<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入完了</title>
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
			<h3>購入が完了しました</h3>
			<a class="btn btn-success" href="IndexServlet" role="button">引き続き買い物をする</a>
			<a class="btn btn-success" href="UserShowServlet" role="button">ユーザー情報へ</a>
		</div>
	</div>



</body>
</html>