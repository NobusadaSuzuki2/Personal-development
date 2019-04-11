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
<title>管理者画面</title>
</head>
<header>
	<div class="container">
		<div class="homeHeader">
			<a href="AdminInfoServlet" style="color: white !important;">HOME</a>
		</div>
		<div class="header-right">
			<a href="LogoutServlet" class="logout">ログアウト</a>
		</div>
		<div class="header-right">
			<a href="ItemSignupServlet" class="signup">商品登録</a>
		</div>
	</div>
</header>

<body style="background-color: #e9ecef75;">
	<div class="top-wrapper">
		<div class="container">
			<h1>商品マスター一覧</h1>
			<h3>
				<input type="text" name="user_name" size="10" placeholder="商品名">
			</h3>
			<h3>
				<input type="text" name="example3" size="10" placeholder="登録日">
				〜<input type="text" name="example4" size="10" placeholder="登録日">
			</h3>
			<div class="btn-wrapper">
				<a class="btn btn-primary" href="#" role="button">検索</a>
			</div>

			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">商品名</th>
						<th scope="col">登録日</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody class="tbody-White">
					<c:forEach var="item" items="${itemList}">
						<tr>
							<td>${item.name}</td>
							<td>${item.createDate}</td>
							<td><a class="btn btn-primary" href="adminItemInfo.html"
								role="button">詳細</a> <a class="btn btn-success"
								href="itemUpdate.html" role="button">更新</a> <a
								class="btn btn-danger" href="destroy.html" role="button">削除</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>