<%@page import="userManagement.UserManagementDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="./css/bootstrap.css">
	<title></title>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script> <!--Ajax를 위해서 공식사이트 에서 제공하는 jquery를 가져온다.  -->
	<script src="./js/bootstrap.js"></script>
</head>
<body>
	<c:if test="${session.user_email!=null}">
		<c:set var="user_email" property="${session.user_email}"/>
	</c:if>
<%--
	<c:if test="${user_email == null}">
		<script type="text/javascript">
			alert("로그인 후 이용할 수 있습니다.");
			location.href="/loginPage.um";
		</script>
	</c:if>
--%>
<%--	
	<c:set var="umdto" property="${param.umdto}"/>
	<!-- 회원가입 양식 -->
	<div class="container">
--%>
	<%
		UserManagementDTO umdto = (UserManagementDTO) request.getAttribute("umdto");
		String user_nickname = umdto.getUser_nickname();
	%>

	<form method="post" action="./JoinAction.um" name="userInfo" onsubmit="return checkValue()">
		<table class="table table-bordered table-hover" style="text-align: center; border: 1px solid #dddddd">
			<thead>
				<tr>
					<th colspan="3"><h4 align="center">회원정보수정</h4></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td style="width: 110px;">
						<h5>이메일</h5>
					</td>
					
					<td colspan="2" style="text-align: left; vertical-align: middle;">
						<span>${user_email}</span>
<%-- 						<input class="form-control" type="email" id="user_email" name="user_email" maxlength="20" value="${user_email}" readonly="readonly""> --%>
					</td>
				</tr>
				<tr>
						<td style="width: 110px;">
							<h5>비밀번호</h5>
						</td>
						<td colspan="2">
							<input class="form-control" type="password" id="user_pass" name="user_pass" maxlength="20" placeholder="비밀번호를 입력해주세요.">
						</td>
					</tr>
					<tr>
						<td style="width: 110px;">
							<h5>닉네임</h5>
						</td>
						<td colspan="2">
							<input class="form-control" type="text" id="user_nickname" name="user_nickname" maxlength="20" value="<%=user_nickname%>"></td>
					</tr>
					<tr>
						<td style="width: 110px;">
							<h5>생년월일</h5>
						</td>
						<td colspan="2">
							<input class="form-control" type="date" id="user_birth" name="user_birth" maxlength="20" <%-- value="${umdto.user_birth}" --%>>
						</td>
					</tr>
					<tr>
						<td style="width: 110px;">
							<h5>성별</h5>
						</td>
						<td colspan="2">
							<div class="form-group" style="text-align: center; margin:0 auto;">
								<div class="btn-group" data-toggle="buttons">
									<label class="btn btn-primary active">
										<input type="radio" name="user_Gender" autocomplete="off" value="남자" checked="checked">남자
									</label>
									<label class="btn btn-primary">
										<input type="radio" name="user_Gender" autocomplete="off" value="여자">여자
									</label>
								</div>
							</div>
						</td>
					</tr>
					
					<tr>
						<td style="text-align: left;" colspan="3">
							<h5 style="color: red;" id="passwordCheckMessage"></h5>
							<input class="btn btn-primary pull-right" type="submit" value="등록">
						</td>   
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	
	
 </body>
</html>