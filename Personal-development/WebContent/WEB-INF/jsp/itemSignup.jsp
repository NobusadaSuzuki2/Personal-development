<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/original/common.css">
<link rel="stylesheet" href="css/original/header.css">
<title>商品登録</title>
</head>
<header>
	<div class="container">
		<div class="homeHeader">
			<a href="AdminInfoServlet" style="color: white !important;">HOME</a>
		</div>
		<div class="header-right">
			<a href="LogoutServlet" class="logout">ログアウト</a>
		</div>
	</div>
</header>
<body style="background-color: #e9ecef75;">
	<div class="top-wrapper">
		<div class="container">
			<c:if test="${errMsg != null}">
				<div class="alert alert-danger" role="alert">${errMsg}</div>
			</c:if>
			<h1>商品情報登録</h1>
			<H1></H1>

			<form action="ItemSignupServlet" method="post">

				<h3>
					<input type="text" name="itemName" placeholder="商品名">
				</h3>
				<h3>
					<input type="text" name="itemPrice" placeholder="商品価格">
				</h3>
				<h3>
					<input type="text" name="stock" placeholder="在庫数">
				</h3>
				<h3>
					<textarea style="width: 1000px; height: 150px;" name="detail"
						placeholder="商品詳細"></textarea>
				</h3>

				<p>
					<input type="file" name="datafile">
				</p>

				<div class="btn-wrapper">
					<button class="btn btn-success" type="submit">登録</button>
				</div>
			</form>
		</div>
		<a class="btn btn-primary" href="AdminInfoServlet" role="button">戻る</a>
	</div>


</body>
</html>