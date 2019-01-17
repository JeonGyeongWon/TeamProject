<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<script type="text/javascript">
	//로그인 유효성 검사를 위한 자바스크립트(추후 ajax로 변경 예정)
	function check() { //<form>태그(name=login_form)의 submit 발생 시
		var login_form = document.login_form;
		if (!login_form.user_email.value) { //user_email의 입력값이 없을 때
			alert("이메일 주소를 입력해주십시오.");
			login_form.user_email.focus();

			return false;
		}
		if (!login_form.user_pass.value) { //user_pass의 입력값이 없을 때
			alert("비밀번호를 입력해주십시오.");
			login_form.user_pass.focus();

			return false;
		}
		location.href = "./loginPro.um"; //user_email과 user_pass 모두 입력값이 있을 때
	}
</script>
<style type="text/css">
h2#login_label {
	font-weight: bold;
	color: blue;
}

table#login_table {
	border: 5px double red;
	padding: 10px;
	margin: 10px;
	border-radius: 11px;
}

p#login_joinInfo {
	font-size: 0.8rem;
}

p#login_joinInfo a {
	font-weight: bold;
	color: green;
	text-decoration: none;
	font-size: 1rem;
}
</style>
<script>
	var width = 450; //폭
	var height = 200;//높이
	var winL = (screen.width - width) / 2; 
	var winT = (screen.height - height) / 2;
	var property = "width=" + width + "," + "height=" + height + "," 
					+ "left=" + winL + "," + "top=" + winT + " menubar=no";
	
function siteInfo2() {	
	window.open('./passPage.um',"",property);
}
</script>
</head>
<body>
	<center>
		<c:if test="${session.user_email != null}">
			<c:set var="user_email" property="${session.user_email}" />
		</c:if>
		<c:if test="${user_email != null}">
			<script type="text/javascript">
				alert("이미 로그인되어 있습니다.");
				location.href = "../main.um";
			</script>
		</c:if>
		<h2 id="login_label">로그인</h2>
		<form action="./loginPro.um" method="post" name="login_form"
			onsubmit="return check()">
			<table id="login_table">
				<tr>
					<th><label for="user_email">아이디:</label></th>
					<td><input type="email" name="user_email"
						placeholder="이메일 입력.." size="20" /></td>
				</tr>
				<tr>
					<th><label for="user_pass">패스워드:</label></th>
					<td><input type="password" name="user_pass"
						placeholder="패스워드 입력.." size="20"></td>
				</tr>
				<tr align="center">
					<td colspan="2" align="center"><br /> <input type="submit"
						value="확    인"> <input type="reset" value="다시 입력">
					</td>
				</tr>
			</table>
		</form>
		<p id="login_joinInfo">
			아직 회원이 아니신가요? <a href="./joinPage.um">회원가입</a>하러 가기
		</p>
		<p id="login_joinInfo">비밀번호를 모르시나요? <a href="javascript:siteInfo2()">비밀번호</a>찿기</p>
	</center>
</body>
</html>