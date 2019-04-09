<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報詳細</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="common.css">
<link rel="stylesheet" href="header.css">
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

<body style="background-color: #e9ecef75;">
	<div class="top-wrapper">
		<div class="container">
			<div class="userBack">

				<h1>ユーザー情報</h1>
				<div class="card" style="background-color: #f7f4f7;">
					<div class="card-body">
						<div style="width: 50%; float: left;">
							<p>名前</p>
							<h3>
								<input type="text" name="loginId" value="second">
							</h3>
						</div>
						<div>
							<p>ログインID</p>
							<h3>
								<input type="text" name="loginId" value="2nd">
							</h3>
						</div>
						<p>住所</p>
						<h3>
							<input type="text" name="loginId" size="50"
								value="東京都中央区日本橋箱崎町２７−２ 渡菊第3ビル６階">
						</h3>
						<div>
							<a class="btn btn-success" href="show.html" role="button">更新</a>
						</div>
					</div>
				</div>

				<div class="userInfo">
					<a class="btn btn-primary" href="userBuyHistory.html" role="button">購入履歴</a>
				</div>
				<div class="userInfo">
					<a class="btn btn-primary" href="index.html" role="button">ホームに戻る</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>