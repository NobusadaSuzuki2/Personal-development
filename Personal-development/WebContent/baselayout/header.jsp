<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="red darken-4" role="navigation">
	<div class="container">

		<div class="homeHeader">
			<a href="IndexServlet" style="color: white !important;">HOME</a>
		</div>
		<%
			boolean isLogin = session.getAttribute("isLogin") != null ? (boolean) session.getAttribute("isLogin")
					: false;
		%>
		<%
			if (isLogin) {
		%>
		<div class="header-right">
			<a href="LogoutServlet"><i class="material-icons">exit_to_app</i></a>
		</div>
		<%
			} else {
		%>
		<div class="header-right">
			<a href="LoginServlet"><i class="material-icons">vpn_key</i></a>
		</div>
		<%
			}
		%>

		<div class="header-right">
			<a href="CartServlet"><i class="material-icons">shopping_cart</i></a>
		</div>
		<%
			if (isLogin) {
		%><div class="header-right">
			<a href="UserShowServlet"><i class="material-icons">account_circle</i></a>
		</div>
		<%
			} else {
		%>

		<div class="header-right">
			<a href="Regist"><i class="material-icons">add</i></a>
		</div>
		<%
			}
		%>
	</div>
</nav>