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
<title>購入履歴</title>
<jsp:include page="/baselayout/head.html" />
</head>
<header>
	<jsp:include page="/baselayout/header.jsp" />
</header>
<body style="background-color: #e9ecef75;">

	<div class="top-wrapper">
		<div class="container" style="width: 50%;">

			<h1>購入履歴</h1>
			<form action="UserBuyHistoryServlet" method="Post">
				<h3>
					<input type="text" name="buyDay" size="10" placeholder="購入日">
					〜 <input type="text" name="buyDay2" size="10" placeholder="購入日">
				</h3>
				<div class="btn-wrapper">
					<button class="btn btn-primary" type="submit">検索</button>
				</div>
			</form>

			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th></th>
						<th>購入ID</th>
						<th>購入日</th>
						<th>合計金額</th>
					</tr>
				</thead>
				<tbody class="tbody-White">
					<c:forEach var="bdb" items="${bdbList}">
						<tr>
							<th><a class="btn btn-primary" href="BuyInfoServlet?id=${bdb.id}"
								role="button">詳細</a></th>
								<th>${bdb.id}</th>
							<th>${bdb.buyDate}</th><fmt:formatNumber value="${bdb.totalPrice}" pattern=",000"
								var="totalResult" />
							<th>${fn:replace(totalResult, ",", ",")}円</th>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>