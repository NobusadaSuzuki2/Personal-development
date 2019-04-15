<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除画面</title>
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


<div class="top-wrapper">
	<div class="container">
		<h1>ユーザー削除確認</h1>
		<h3>${itemid.name}</h3>

		<p>を本当に削除してよろしいでしょうか。</p>
		<form class="form-signin" action="DestroyServlet" method="post">
			<input type="hidden" name="id" value="${itemid.id}">
			<div class="btn-wrapper">
				<a class="btn btn-primary" href="AdminInfoServlet" role="button">キャンセル</a>
					<button class="btn btn-danger" type="submit">OK</button>
			</div>
		</form>
	</div>
</div>




</body>
</html>