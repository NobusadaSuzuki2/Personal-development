<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
								<fmt:formatNumber value="${item.price}" pattern=",000"
									var="result" />
								<td>${fn:replace(result, ",", ",")}円</td>
							</tr>
						</c:forEach>
						<fmt:formatNumber value="${bdb.totalPrice}" pattern=",000"
							var="totalResult" />
						<tr>
							<th scope="row"></th>
							<td></td>
							<td align="right">合計金額</td>
							<td class="buyG">${fn:replace(totalResult, ",", ",")}円</td>
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