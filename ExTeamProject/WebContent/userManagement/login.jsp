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
<style rel="stylesheet">
body {
   font: 13px/20px 'Helvetica Neue', Helvetica, Arial, sans-serif;
   color: #333333;
   background:;
}

.signUp {
   position: relative;
   margin: 50px auto;
   width: 500px;
   padding: 33px 25px 25px;
   background: #FFFFFF;
   border-bottom: 1px solid #C4C4C4;
   border-radius: 5px;
   -webkit-box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);
   box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);
}

.signUp:before,
.signUp:after {
   content: '';
   position: absolute;
   bottom: 1px;
   left: 0;
   right: 0;
   height: 10px;
   background: inherit;
   border-bottom: 1px solid #D2D2D2;
   border-radius: 4px;
}

.signUp:after {
   bottom: 3px;
   border-color: #DCDCDC;
}

.signUpTitle {
   margin: -25px -25px 25px;
   padding: 15px 25px;
   line-height: 35px;
   font-size: 26px;
   font-weight: 300;
   color: #777;
   text-align: center;
   text-shadow: 0 1px rgba(255, 255, 255, 0.75);
   background: #F7F7F7;
}

.signUpTitle:before {
   content: '';
   position: absolute;
   top: 0;
   left: 0;
   right: 0;
   height: 8px;
   background: #C4E17F;
   border-radius: 5px 5px 0 0;
   background-image: -webkit-linear-gradient(left, #C4E17F, #C4E17F 12.5%, #F7FDCA 12.5%, #F7FDCA 25%, #FECF71 25%, #FECF71 37.5%, #F0776C 37.5%, #F0776C 50%, #DB9DBE 50%, #db9CBE 62.5%, #C49CDE 62.5%, #C49CDE 75%, #669AE1 75%, #669AE1 87.5%, #62C2E4 87.5%, #62C2E4);
   background-image: -moz-linear-gradient(left, #c4e17f, #C4E17F 12.5%, #F7FDCA 12.5%, #F7FDCA 25%, #FECF71 25%, #FECF71 37.5%, #F0776C 37.5%, #F0776C 50%, #DB9DBE 50%, #DB9CBE 62.5%, #C49CDE 62.5%, #C49CDE 75%, #669AE1 75%, #669AE1 87.5%, #62C2E4 87.5%, #62C2E4);
   background-image: -o-linear-gradient(left, #C4E17F, #C4E17F 12.5%, #F7FDCC 12.5%, #F7FDCA 25%, #FECF71 25%, #FECF71 37.5%, #F0776C 37.5%, #F0776C 50%, #DB9DBE 50%, #DB9DBE 62.5%, #C49CDE 62.5%, #C49CDE 75%, #669AE1 75%, #669AE1 87.5%, #62C2E4 87.5%, #62C2E4);
   background-image: linear-gradient(to right, #C4E17F, #C4E17F 12.5%, #F7FDCA 12.5%, #F7FDCA 25%, #FECF71 25%, #FECF71 37.5%, #F0776C 37.5%, #F0776C 50%, #DB9DBE 50%, #DB9CBE 62.5%, #c49cde 62.5%, #C49CDE 75%, #669AE1 75%, #669AE1 87.5%, #62c2e4 87.5%, #62C2E4);
}

input {
   font-family: inherit;
   color: inherit;
   -webkit-box-sizing: border-box;
   -moz-box-sizing: border-box;
   box-sizing: border-box;
}

.signUpInput {
   width: 180%;
   height: 50px;
   margin-bottom: 25px;
   padding: 0 15px 2px;
   font-size: 17px;
   background: white;
   border: 2px solid #EBEBEB;
   border-radius: 4px;
   -webkit-box-shadow: inset 0 -2px #EBEBEB;
   box-shadow: inset 0 -2px #EBEBEB;
}

.signUpInput:focus {
   border-color: #62C2E4;
   outline: none;
   -webkit-box-shadow: inset 0 -2px #62C2E4;
   box-shadow: inset 0 -2px #62C2E4;
}

.lt-ie9 .signUpInput {
   line-height: 48px;
}

.signUpButton {
   position: relative;
   vertical-align: top;
   width: 180%;
   height: 54px;
   padding: 0;
   font-size: 22px;
   color: white;
   text-align: center;
   text-shadow: 0 1px 2px rgba(0, 0, 0, 0.25);
   background: #F0776C;
   border: 0;
   border-bottom: 2px solid #D76B60;
   border-radius: 5px;
   cursor: pointer;
   -webkit-box-shadow: inset 0 -2px #D76B60;
   box-shadow: inset 0 -2px #D76B60;
}

.signUpButton:active {
   top: 1px;
   outline: none;
   -webkit-box-shadow: none;
   box-shadow: none;
}

:-moz-placeholder {
   color: #AAAAAA;
   font-weight: 300;
}

::-moz-placeholder {
   color: #AAAAAA;
   opacity: 1;
   font-weight: 300;
}

::-webkit-input-placeholder {
   color: #AAAAAA;
   font-weight: 300;
}

:-ms-input-placeholder {
   color: #AAAAAA;
   font-weight: 300;
}

::-moz-focus-inner {
   border: 0;
   padding: 0;
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
	var width = 700; //폭
	var height = 550;//높이
	var winL = (screen.width - width) / 2;
	var winT = (screen.height - height) / 2;
	var property = "width=" + width + "," + "height=" + height + "," + "left="
			+ winL + "," + "top=" + winT + " menubar=no";

	function siteInfo2() {
		window.open('./findPassPage.um', "", property);
	}
</script>
</head>
<body>
	<form class="signUp" id="signupForm">
		<h2 class="signUpTitle" id="login_label">로그인</h2>
		<form action="./loginPro.um" method="post" name="login_form" onsubmit="return check()">
			<table id="login_table">
				<tr>
					<th><label for="user_email"></label></th>
					<td><input class="signUpInput" type="email" name="user_email"
						placeholder="이메일 입력.." size="20" /></td>
				</tr>
				<tr>
					<th><label for="user_pass"></label></th>
					<td><input class="signUpInput" type="password" name="user_pass"
						placeholder="패스워드 입력.." size="20"></td>
				</tr>
				<tr align="center">
					<td colspan="2" align="center"><br /> 
                      <input class="signUpButton" type="submit" value="확    인"> 
					</td>
				</tr>
			</table>
		</form>
		<p id="login_joinInfo" align="center">
			아직 회원이 아니신가요? <a href="./joinPage.um">회원가입</a>하러 가기
		</p>
		<p id="login_joinInfo" align="center">비밀번호를 모르시나요? <a href="javascript:siteInfo2()">비밀번호</a>찿기</p>
	

	</form>
	</body>
	</html>
	