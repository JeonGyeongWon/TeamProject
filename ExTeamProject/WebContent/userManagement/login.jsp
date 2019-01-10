<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
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
	p#login_joinInfo a{
		font-weight: bold;
		color: green;
		text-decoration: none;
		font-size: 1rem;
	}
</style>
</head>
<body>
<center>
	<h2 id="login_label">로그인</h2>
	<form action="loginPro.us" method="post">
	<table id="login_table">
		<tr>
			<th>
				아이디:
			</th>
			<td>
				<input type="email" name="user_email" placeholder="이메일 입력.." size="20"/>
			</td>
		</tr>
		<tr>
			<th>
				패스워드:
			</th>
			<td>
				<input type="password" name="user_pass" placeholder="패스워드 입력.." size="20">
			</td>
		</tr>
		<tr align="center">
			<td colspan="2" align="center">
				<br/>
				<input type="submit" value="확    인">
				<input type="reset" value="다시 입력">
			</td>
		</tr>
	</table>
	</form>
	<p id="login_joinInfo">아직 회원이 아니신가요? <a href="joinPage.um">회원가입</a>하러 가기</p>
</center>
</body>
</html>