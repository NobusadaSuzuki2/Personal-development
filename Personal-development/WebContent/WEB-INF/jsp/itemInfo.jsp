<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/original/common.css">
<link rel="stylesheet" href="css/original/header.css">
</head>
<header>
	<div class="container">
		<div class="homeHeader">
			<a href="IndexServlet" style="color: white !important;">HOME</a>
		</div>

		<div class="header-right">
			<a href="LogoutServlet" class="logout">ログアウト</a>
		</div>
		<div class="header-right">
			<a href="signupServlet" class="signup">新規登録</a>
		</div>
		<div class="header-right">
			<a href="CartServlet" class="cart">カート</a>
		</div>
	</div>
</header>

<body style="background-color: #e9ecef75;">
	<div class="top-wrapper">
		<div class="container" style="width: 1200px">
			<h3>商品詳細</h3>
			<form action="CartServlet" method="post">
			<input type="hidden" name="item.id" value="${itemInfo.id}">
				<button class="btn btn-success" type="submit" style="float: right;">カートに追加</button>
				<br> <br> <br> <br>
			</form>
			<div class="row">
				<div class="col s6">
					<div class="card">
						<div class="card-image">
							<img style="width: 100%; heigth: 100%;"
								src="img/${itemInfo.fileName}">
						</div>
					</div>
				</div>
				<div class="col s6">
					<h4>${itemInfo.name}</h4>
					<h5>${itemInfo.price}円</h5>
					<p>${itemInfo.detail}</p>
				</div>
			</div>
		</div>
	</div>


</body>
</html>