<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入画面</title>
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
			<h3>購入内容をご確認の上、購入してください</h3>

			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th>お届け場所</th>
						<th>受取人のお名前</th>
					</tr>
				</thead>
				<tbody class="tbody-White">
					<tr>
						<th><h5>東京都中央区日本橋箱崎町２７−２ 渡菊第3ビル６階</h5></th>
						<td><h5>second</h5></td>
					</tr>
				</tbody>
			</table>

			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">商品名</th>
						<th scope="col"></th>
						<th scope="col"></th>
						<th scope="col"></th>
						<th scope="col">価格</th>
					</tr>
				</thead>
				<tbody class="tbody-White">
					<tr>
						<th scope="row">座椅子</th>
						<td></td>
						<td></td>
						<td></td>
						<td>8990円</td>
					</tr>
					<tr>
						<th scope="row">お茶</th>
						<td></td>
						<td></td>
						<td></td>
						<td>699円</td>
					</tr>
					<tr>
						<th scope="row">合鍵</th>
						<td></td>
						<td></td>
						<td></td>
						<td>790円</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td>配送方法</td>
						<td>特急便</td>
						<td>500円</td>
					</tr>
					<tr>
						<th scope="row"></th>
						<td></td>
						<td></td>
						<td>合計金額</td>
						<td>10979円</td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td><a class="btn btn-success" href="buyComplete.html"
							role="button">購入を確定する</a></td>

					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>