<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
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
			<h1>商品一覧</h1>
			<form action="SearchServlet" method="post">
				<h3>
					<input class="search" type="text" name="search">
				</h3>

				<div class="btn-wrapper">
					<button class="btn btn-primary" type="submit">検索</button>
				</div>
			</form>
			<div class="row">
				<c:forEach var="item" items="${itemList}">

					<div class="card col-sm-3">
						<div class="card-image">
							<a href="ItemInfoServlet?id=${item.id}"><img
								style="height: 250px" src="img/${item.fileName}"></a>
						</div>
						<div class="card-content">
							<span class="card-title">${item.name}</span>
							<div style="position: absolute; bottom: 0;">
								<p>価格：￥${item.price}</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div  style="text-align: center!important; display: inline-block;">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item"><a class="page-link"
							href="SearchServlet?search=${search}&page_num=${pageNum - 1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
						<c:forEach begin="${(pageNum - 5) > 0 ? pageNum - 5 : 1}"
							end="${(pageNum + 5) > pageMax ? pageMax : pageNum + 5}" step="1"
							varStatus="status">
							<li <c:if test="${pageNum == status.index }"></c:if>></li>
							<li class="page-item"><a class="page-link"
								href="SearchServlet?search=${search}&page_num=${status.index}">${status.index}</a></li>
						</c:forEach>
						<li class="page-item"><a class="page-link"
							href="SearchServlet?search=${search}&page_num=${pageNum + 1}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
</body>

<footer>
	<nav class="navbar fixed-bottom navbar-expand-sm navbar-dark bg-dark">
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav mr-auto">
			</ul>
		</div>
	</nav>
</footer>
</html>