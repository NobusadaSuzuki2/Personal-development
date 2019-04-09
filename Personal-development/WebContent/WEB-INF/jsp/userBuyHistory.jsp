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
<link rel="stylesheet" href="common.css">
<link rel="stylesheet" href="header.css">
<title>購入履歴</title>
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
<body style="background-color:#e9ecef75;">

	<div class="top-wrapper">
		<div class="container">

			<h1>購入履歴</h1>
			<h3>
				<input type="text" name="buy_id" placeholder="購入ID">
			</h3>
			<h3>
				<input type="text" name="item_name" placeholder="商品名">
			</h3>
			<h3>
				<input type="text" name="example3" size="10" placeholder="購入日">
				〜
				<input type="text" name="example4" size="10" placeholder="購入日">
			</h3>
			<div class="btn-wrapper">
				<a class="btn btn-primary" href="#" role="button">検索</a>
			</div>

			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th></th>
						<th>購入ID</th>
						<th>商品名</th>
						<th>購入日</th>
						<th>合計金額</th>
					</tr>
				</thead>
				<tbody class="tbody-White">
					<tr>
						<th><a class="btn btn-primary" href="buyInfo.html" role="button">詳細リンク</a></th>
						<th>購入ID</th>
						<th>デスク用椅子</th>
						<th>1234年5月6日78時90分</th>
						<th>12,345円</th>
					</tr>
					<tr>
						<th><a class="btn btn-primary" href="buyInfo.html" role="button">詳細リンク</a></th>
						<th>購入ID</th>
						<th>デスク用椅子</th>
						<th>1234年5月6日78時90分</th>
						<th>12,345円</th>
					</tr>
					<tr>
						<th><a class="btn btn-primary" href="buyInfo.html" role="button">詳細リンク</a></th>
						<th>購入ID</th>
						<th>デスク用椅子</th>
						<th>1234年5月6日78時90分</th>
						<th>12,345円</th>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>