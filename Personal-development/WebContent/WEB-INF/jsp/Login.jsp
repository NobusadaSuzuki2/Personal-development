<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
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
			<a href="index.html" style="color: white !important;">HOME</a>
		</div>
		<div class="header-right">
			<a href="Login.html" class="logout">ログアウト</a>
		</div>
		<div class="header-right">
			<a href="signup.html" class="signup">新規登録</a>
		</div>
		<div class="header-right">
			<a href="cart.html" class="cart">カート</a>
		</div>
	</div>
</header>

<c:if test="${loginErrorMessage != null}">
	<div class="alert alert-danger" role="alert">${loginErrorMessage}</div>
</c:if>
<body style="background-color: #e9ecef75;">
	<div class="top-wrapper">
		<div class="container">
			<div class="login">
				<h1>ログイン画面</h1>
				<h1></h1>
				<form class="form-signin" action="LoginServlet" method="post">
					<h3>
						<input type="text" name="login_id" placeholder="ログインID">
					</h3>
					<h3>
						<input type="password" name="password" placeholder="パスワード">
					</h3>

					<div class="btn-wrapper">
					<button class="btn btn-primary" type="submit">ログイン</button>
				</div>
				</form>
			</div>

			<p>
				まだ登録をお済みで無い方はこちらから<a href="signup.html" role="button">新規登録</a>
			</p>



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