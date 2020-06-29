<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html lang="ja">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/skyblue.css">
<link rel="stylesheet" href="./css/pe-icon-7-stroke.css">
<link rel="stylesheet" href="./css/helper.css">
<title>Insert title here</title>
</head>
<body>
<%
String loginId = request.getParameter("loginId");
String userName = request.getParameter("userName");
String password = request.getParameter("password");
String profile = request.getParameter("profile");
String icon=request.getParameter("icon");
session.setAttribute("icon","icon");

%>
	<div class="bg-success padding-y-5">
		<div class="container padding-y-5 text-center">
			<h1>
				変更画面&nbsp;<span class="icon-speaker"></span>
			</h1>
		</div>
	</div>
	<div class="padding-y-5 text-center">
		<div style="width: 40%" class="container padding-y-5 text-center">
			<form action="NewFile4.jsp">
				<table style="width: 400px" class="table">
					<tr>
						<%-- ログインID 入力欄の名前は loginId --%>
						<td class="color-main text-left">ユーザー名</td>
						<td class="text-left"><input class="form-control" type="text"
							name="userName" value=<%=userName %>></td>
						<td><input class="form-control" type="hidden" name="loginId"
							value=<%=loginId %>>
					</tr>
					<tr>
						<td class="color-main text-left">パスワード</td>
						<td class="text-left"><input class="form-control" type="text"
							name="password" value=<%=password %>></td>
					</tr>
					<tr>
						<td class="color-main text-left">コメント</td>
						<td class="text-left"><input class="form-control" type="text"
							name="profile" value=<%=profile%>></td>
					</tr>
										<tr>
						<td class="color-main text-left">性別</td>
						<c:set var="icon" value="${icon}" />
						<c:if test="${icon == 'male'}">
							<td><input type="radio" name="icon" id="male" value="male"
								checked> <span>male</span> <input type="radio"
								name="icon" id="female" value="female"> <span>female</span>
							</td>
						</c:if>
						<c:if test="${icon == 'female'}">
							<input type="radio" name="icon" id="male" value="male">
							<span>male</span>
							<input type="radio" name="icon" id="female" value="female"
								checked>
							<span>female</span>
						</c:if>
					</tr>
					<tr>
						<td colspan="2" class="text-right"><input class="btn"
							type="submit" value="変更する" /></td>
							<td class="text-left"><a href="Research.jsp" class="btn">戻る</a></td>
					</tr>

					<c:if test="${requestScope.alert != null }">
						<tr>
							<%-- リクエストスコープの alert の値を出力 --%>
							<td colspan="2" class="color-error text-left"><c:out
									value="${requestScope.alert}" /></td>
						</tr>
					</c:if>
				</table>
			</form>
		</div>
	</div>
</body>
</html>