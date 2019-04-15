<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
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
			<h3>商品詳細</h3>
			<div class="row">
				<div class="col s6">
					<div class="card">
						<div class="card-image">
							<img src="img/${itemInfo.fileName}" style="width:50%;">
						</div>
					</div>
				</div>
				<div class="col s6">
					<h4>${itemInfo.name}</h4>
					<h5>${itemInfo.price}円</h5>
					<p>${itemInfo.detail}</p>
				</div>

			</div>

			<table class="table">
				<thead class="tbody-White">
					<tr>
						<th scope="col">販売数</th>
						<th scope="col">在庫数</th>
						<th scope="col">登録日</th>
						<th scope="col">更新日</th>
					</tr>
				</thead>
				<tbody class="tbody-White">
					<tr>
						<td>５０個</td>
						<td>５０個</td>
						<td>${itemInfo.createDate}</td>
						<td>${itemInfo.updateDate}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>


</body>
</html>