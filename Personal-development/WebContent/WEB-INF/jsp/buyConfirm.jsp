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
<jsp:include page="/baselayout/head.html" />
</head>
<header>
	<jsp:include page="/baselayout/header.jsp" />
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
						<th><h5>${udb.address}</h5></th>
						<td><h5>${udb.name}</h5></td>
					</tr>
				</tbody>
			</table>
			<form action="BuyCompleteServlet" method="POST">
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
						<c:forEach var="item" items="${cart}" varStatus="status">
							<tr>
								<th scope="row">${item.name}</th>
								<td></td>
								<td></td>
								<td></td>
								<td>${item.price}円</td>
							</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td>配送方法</td>
							<td>${bdb.deliveryMethodName}</td>
							<td>${bdb.deliveryMethodPrice}円</td>
						</tr>
						<tr>
							<th scope="row"></th>
							<td></td>
							<td></td>
							<td>合計金額</td>
							<td>${bdb.totalPrice}円</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td><button class="btn btn-success" type="submit">購入を確定する</button></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>