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
			<h3>購入画面</h3>
			<form action="BuyConfirmServlet" method="post">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">商品名</th>
							<th scope="col"></th>
							<th scope="col"></th>
							<th scope="col">価格</th>
						</tr>
					</thead>
					<tbody class="tbody-White">
						<c:forEach var="item" items="${cart}" varStatus="status">
							<tr>
								<th scope="row">${item.name}</th>
								<td></td>
								<td></td>
								<td>${item.price}円</td>
							</tr>
						</c:forEach>
						<tr>
							<th scope="row"></th>
							<td></td>
							<td align="right">合計金額</td>
							<td class="buyG">${bdb.totalPrice}円</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td class="delivery" align="right">配送方法</td>
							<td class="delivery"><select name="delivery_method_id">
									<c:forEach var="dmdb" items="${dmdbList}">
										<option value="${dmdb.id}">${dmdb.name}</option>
									</c:forEach>
							</select></td>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td><button class="btn btn-primary" type="submit">購入を確認する</button></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>