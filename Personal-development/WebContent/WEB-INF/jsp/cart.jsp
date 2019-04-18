<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート</title>
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

			<div class="alert" style="color: #e25f6b;" role="alert">
				<h1>${cartActionMessage}</h1>
			</div>

			<h3>買い物かご</h3>
			<form action="ItemDeleteServlet" method="POST">
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col" align="left">商品名</th>
							<th scope="col"></th>
							<th scope="col"></th>
							<th scope="col">価格</th>
						</tr>
					</thead>
					<tbody class="tbody-White">
						<c:forEach var="item" items="${cart}" varStatus="status">

							<tr>
								<th scope="row"><a href="ItemInfoServlet?id=${item.id}">${item.name}</a><input
									type="hidden" name="item.id" value="${itrem.id}"></th>
								<td>
									<p>
										<input type="checkbox" name="delete_item_id_list"
											value="${item.id}" /> <label for="${status.index}">削除</label>
									</p>
								</td>

								<td></td>
								<td>${item.price}円</td>
							</tr>

						</c:forEach>

						<tr>
							<th scope="row"></th>
							<td></td>
							<td>合計金額</td>
							<td>${bdb.totalPrice}円</td>
						</tr>

						<tr>
							<td></td>
							<td><button class="btn btn-danger" type="submit">削除</button></td>
							<td><a class="btn btn-success" href="IndexServlet"
								role="button">買い物を続ける</a></td>
							<td><a class="btn btn-primary" href="buy.html" role="button">購入に進む</a>
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>