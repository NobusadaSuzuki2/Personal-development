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
<title>商品更新</title>
</head>
<header>
	<div class="container">
		<div class="homeHeader">
			<a href="adminInfo.html" style="color: white !important;">HOME</a>
		</div>
		<div class="header-right">
			<a href="Login.html" class="logout">ログアウト</a>
		</div>
		<div class="header-right">
			<a href="itemSignup.html" class="signup">商品登録</a>
		</div>
	</div>
</header>
<body style="background-color: #e9ecef75;">
	<div class="top-wrapper">
		<div class="container">
			<h1>商品情報更新</h1>
			<H1></H1>

			<form action="ItemUpdateServlet" method="post">
				<input type="hidden" name="id" value="${itemid.id}">

				<p>商品名</p>
				<h3>
					<input type="text" size="60" name="itemName" value="${itemid.name}">
				</h3>
				<p>価格</p>
				<h3>
					<input type="text" size="10" name="itemPrice"
						value="${itemid.price}">
				</h3>
				<p>商品詳細</p>
				<h3>
					<textarea style="width: 1000px; height: 150px;" name="detail">${itemid.detail}</textarea>
				</h3>

				<p>
					<input type="file" name="datafile">
				</p>

				<div class="btn-wrapper">
					<button class="btn btn-success" type="submit">更新</button>
				</div>
			</form>
		</div>
		<a class="btn btn-primary" href="AdminInfoServlet" role="button">戻る</a>
	</div>


</body>
</html>