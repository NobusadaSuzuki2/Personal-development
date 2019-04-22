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
			<div class="userBack">
				<c:if test="${validationMessage != null}">
					<div class="alert" style="color: #e25f6b;" role="alert">
						<h1>${validationMessage}</h1>
					</div>
				</c:if>
				<h1>ユーザー情報</h1>
				<div class="card" style="background-color: #f7f4f7; height: 300px;">
					<div class="card-body">
						<form action="UserShowServlet" method="post">
							<div style="width: 50%; float: left;">
								<p>名前</p>
								<h3>
									<input type="text" name="userName" value="${udb.name}">
								</h3>
							</div>
							<div>
								<p>ログインID</p>
								<h3>
									<input type="text" name="loginId" value="${udb.loginId}">
								</h3>
							</div>
							<p>住所</p>
							<h3>
								<input type="text" name="address" size="50"
									value="${udb.address}">
							</h3>
							<div>
								<button class="btn btn-success" type="submit" role="button">更新</button>
							</div>
						</form>
					</div>
				</div>

				<div class="userInfo">
					<a class="btn btn-primary" href="UserBuyHistoryServlet"
						role="button">購入履歴</a>
				</div>
				<div class="userInfo">
					<a class="btn btn-primary" href="IndexServlet" role="button">ホームに戻る</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>