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
		<div class="container">
			<h1>商品一覧</h1>
			<h3>
				<input class="search" type="text" name="rogin_id">
			</h3>

			<div class="btn-wrapper">
				<a class="btn btn-primary" href="#" role="button">検索</a>
			</div>

			<div class="card-image">
				<div class="itemImage">
					<img src="http://placehold.jp/250x250.png">
				</div><div class="itemImage">
					<img src="http://placehold.jp/250x250.png">
				</div><div class="itemImage">
					<img src="http://placehold.jp/250x250.png">
				</div><div class="itemImage">
					<img src="http://placehold.jp/250x250.png">
				</div><div class="itemImage">
					<img src="http://placehold.jp/250x250.png">
				</div><div class="itemImage">
					<img src="http://placehold.jp/250x250.png">
				</div><div class="itemImage">
					<img src="http://placehold.jp/250x250.png">
				</div><div class="itemImage">
					<img src="http://placehold.jp/250x250.png">
				</div>
			</div>
		</div>
	</div>
</body>

<footer>
	<nav class="navbar fixed-bottom navbar-expand-sm navbar-dark bg-dark">
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
			</ul>
		</div>
	</nav>
</footer>
</html>