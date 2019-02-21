<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/bootstrap.css">
<title></title>
<!-- jQuery -->
	<script src="/ExTeamProject/js/jquery.min.js"></script>	
	
	<script src="/ExTeamProject/js/bootstrap.min.js"></script>
	
<script type="text/javascript">
<script type="text/javascript">
	//<form>태그로 전송할 값의 유효성 검사
	function checkValue() {

		var re = /^[a-zA-Z0-9]{4,12}$/ // 아이디와 패스워드가 적합한지 검사할 정규식
	    var re2 = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;//email 정규식
	    var date_pattern = /(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[0-1])$/;// 생년월일 정규식
	    
		if (!document.userInfo.user_email.value) {
			alert("이메일을 입력하세요.");
			document.userInfo.user_email.focus();
			return false;
		}
		if (!re2.test(document.userInfo.user_email.value)) {
			alert("적합하지 않은 이메일 형식입니다.");
			document.userInfo.user_email.focus();
			return false;
		}
		if (!document.userInfo.user_pass.value) {
			alert("비밀번호를 입력하세요.");
			document.userInfo.user_pass.focus();
			return false;
		}
		if (!re.test(document.userInfo.user_pass.value)) {
			alert("패스워드는 4~12자의 영문 대소문자와 숫자로만 입력");
			document.userInfo.user_pass.focus();
			return false;
		}
		// 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
		if (document.userInfo.user_pass.value != document.userInfo.user_passcheck.value) {
			alert("비밀번호를 동일하게 입력하세요.");
			document.userInfo.user_passcheck.focus();
			return false;
		}
		if (!document.userInfo.user_nickname.value) {
			alert("닉네임을 입력하세요.");
			document.userInfo.user_nickname.focus();
			return false;
		}
		if (!re.test(document.userInfo.user_nickname.value)) {
			alert("닉네임은 4~12자의 영문 대소문자와 숫자로만 입력");
			document.userInfo.user_pass.focus();
			return false;
		}
		if (!document.userInfo.user_birth.value) {
			alert("생년월일을 입력하세요.");
			document.userInfo.user_birth.focus();
			return false;
		}
		if (!date_pattern.test(document.userInfo.user_birth.value)) {
			alert("적합하지않은 생년월일입니다.");
			document.userInfo.user_pass.focus();
			return false;
		}
		if (isNaN(document.userInfo.user_birth.value)) {
			alert("생년월일은 반드시 숫자로만 입력해야 합니다. ex)941111");
			document.userInfo.user_birth.focus();
			return false;
		}

		if (document.userInfo.user_birth.value.length != 6) {
			alert("생년월일은 반드시 6자 입력해야 합니다. ex)941111");
			document.userInfo.user_birth.value = "";
			document.userInfo.user_birth.focus();
			return false;
		}

		if (document.userInfo.idDuplication.value != "emailCheck") {
			alert("이메일 중복체크를 해주세요.");
			return false;
		}

	}

	//user_email 중복 확인창 열기
	function openIdChk() {
		window.name = "parentForm";
		window.open("./userManagement/emailCheckForm.jsp", "emailCheck",
				"width=400, height=450, top=250, left=800");
	}

	// 아이디 입력창에 값 입력시 hidden에 user_emailUncheck를 세팅한다.
	// 이렇게 하는 이유는 중복체크 후 다시 아이디 창이 새로운 아이디를 입력했을 때
	// 다시 중복체크를 하도록 한다.
	function inputIdChk() {
		document.userInfo.idDuplication.value = "user_emailuncheck";
	}
</script>
</head>
<body>
	<!-- 로그인 세션 -->
	<c:if test="${session.user_email != null}">
		<c:set var="user_email" property="${session.user_email}" />
	</c:if>
	<!-- 로그인 상태에서는 회원가입 기능을 사용할 수 없도록 막는다 -->
	<c:if test="${user_email != null}">
		<script type="text/javascript">
			alert("이미 로그인되어 있습니다.");
			location.href = "./main.um";
		</script>
	</c:if>

	<!-- 회원가입 양식 -->
	<div class="container">

		<form method="post" action="./joinAction.um" name="userInfo"
			onsubmit="return checkValue()">
			<table class="table table-bordered table-hover"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3"><h4 align="center">회원가입</h4></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 110px;">
							<h5>이메일</h5>
						</td>

						<td><input class="form-control" type="email" id="user_email"
							name="user_email" maxlength="20" placeholder="이메일을 입력해주세요"
							onkeydown="inputIdChk()"></td>
						<td style="width: 110px;">
							<button class="btn btn-primary" onclick="openIdChk();"
								type="button">중복체크</button> <!-- 아이디중복체크했는지 하지 않았는지에 대한 값  0:하지 않음, 1:함 -->
							<input type="hidden" name="idDuplication" id="user_emailCheck"
							value="user_emailuncheck"/>
						</td>
					</tr>
					<tr>
						<td style="width: 110px;">
							<h5>비밀번호</h5>
						</td>
						<td colspan="2"><input class="form-control" type="password"
							id="user_pass" name="user_pass" maxlength="20"
							placeholder="비밀번호를 입력해주세요" ></td>
					</tr>
					<tr>
						<td style="width: 110px;">
							<h5>비밀번호 확인</h5>
						</td>
						<td colspan="2"><input class="form-control" type="password"
							id="user_passcheck" name="user_passcheck" maxlength="20"
							placeholder="비밀번호 확인을 입력해주세요" maxlength="12"></td>
					</tr>
					<tr>
						<td style="width: 110px;">
							<h5>닉네임</h5>
						</td>
						<td colspan="2"><input class="form-control" type="text"
							id="user_nickname" name="user_nickname" maxlength="20"
							placeholder="닉네임을 입력해주세요" maxlength="12"></td>
					</tr>
					<tr>
						<td style="width: 110px;">
							<h5>생년월일</h5>
						</td>
						<td colspan="2"><input class="form-control" type="text"
							id="user_birth" name="user_birth" maxlength="6"
							placeholder="생년월일을 입력해주세요"ex)941111></td>
					</tr>
					<tr>
						<td style="width: 110px;">
							<h5>성별</h5>
						</td>
						<td colspan="2">
							<div class="form-group"
								style="text-align: center; margin: 0 auto;">
								<div class="btn-group" data-toggle="buttons">
									<label class="btn btn-primary active"> <input
										type="radio" name="user_gender" autocomplete="off" value="남"
										checked="checked">남자
									</label> <label class="btn btn-primary"> <input type="radio"
										name="user_gender" autocomplete="off" value="여">여자
									</label>
								</div>
							</div>
						</td>
					</tr>

					<tr>
						<td style="text-align: left;" colspan="3">
							<h5 style="color: red;" id="passwordCheckMessage"></h5> <input
							class="btn btn-primary pull-right" type="submit" value="등록">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>


</body>
</html>

