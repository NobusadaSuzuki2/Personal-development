<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<title>購入詳細</title>
<jsp:include page="/baselayout/head.html" />
</head>
<header>
	<jsp:include page="/baselayout/header.jsp" />
</header>
<body style="background-color: #e9ecef75;">
	<div class="top-wrapper">
		<div class="container">
			<h1>購入詳細</h1>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th>購入日</th>
						<th>お届け場所</th>
						<th>受取人のお名前</th>
					</tr>
				</thead>
				<tbody class="tbody-White">
					<tr>
						<th>${bdb.buyDate}</th>
						<th><h5>${udb.address}</h5></th>
						<td><h5>${udb.name}</h5></td>
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
					<c:forEach var="item" items="${itemList}">
						<tr>
							<th scope="row">${item.name}</th>
							<td></td>
							<td></td>
							<td></td><fmt:formatNumber value="${item.price}" pattern=",000"
									var="result" />
								<td>${fn:replace(result, ",", ",")}円</td>
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
						<td>合計金額</td><fmt:formatNumber value="${bdb.totalPrice}" pattern=",000"
								var="totalResult" />
							<td>${fn:replace(totalResult, ",", ",")}円</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>