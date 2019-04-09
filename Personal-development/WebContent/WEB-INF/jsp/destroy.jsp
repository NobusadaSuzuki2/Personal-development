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
<link rel="stylesheet" href="common.css">
<link rel="stylesheet" href="header.css">
<link href="Materialize/css/materialize.css" type="text/css"
	rel="stylesheet" media="screen,projection" />
</head>
<header>
	<div class="container">
		<div class="homeHeader">
			<a href="adminInfo.html" style="color: white !important;">HOME</a>
		</div>
		<div class="header-right">
			<a href="Login.html" class="logout">ログアウト</a>
		</div>
		<div class="header-right">
			<a href="itemSignup.html" class="signup">商品登録</a>
		</div>
	</div>
</header>


<div class="top-wrapper">
	<div class="container">
		<h1>ユーザー削除確認</h1>
		<h3>Mark</h3>

		<p>を本当に削除してよろしいでしょうか。</p>
		<div class="btn-wrapper">
			<a class="btn btn-primary" href="adminInfo.html" role="button">キャンセル</a>
			<a class="btn btn-danger" href="adminInfo.html" role="button">OK</a>

		</div>
	</div>
</div>




</body>
</html>