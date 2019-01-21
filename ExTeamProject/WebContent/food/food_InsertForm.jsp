<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>맛집 정보 등록</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!-- 다음주소찾기 ... -->
<script type="text/javascript">
	<%-- 서브이미지 1개 존재할 때, 추가 이미지 파일 업로드 공간 5개 확보 --%>
	$(function() {
		$("#detailImg input[type=file]").on("change", function() {
			$("#subimg").html("서브이미지 선택!! 최대5개 ");
			for (var i = 2; i < 7; i++) {
				var file = "<input type='file' name='f_img"+i+"'>";
				$("#subimg").append(file);
			}
		});
	});
	
	<%--팝업창을 이용한 찾기를 가져옴--%>
	function execDaumPostcode() {
		new daum.Postcode({
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
						// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
						// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
						var roadAddr = data.roadAddress; // 도로명 주소 변수
						var extraRoadAddr = ''; // 참고 항목 변수
						// 법정동명이 있을 경우 추가한다. (법정리는 제외)
						// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
						if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
							extraRoadAddr += data.bname;
						}
						// 건물명이 있고, 공동주택일 경우 추가한다.
						if (data.buildingName !== '' && data.apartment === 'Y') {
							extraRoadAddr += (extraRoadAddr !== '' ? ', '
									+ data.buildingName : data.buildingName);
						}
						// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
						if (extraRoadAddr !== '') {
							extraRoadAddr = ' (' + extraRoadAddr + ')';
						}
						// 우편번호와 주소 정보를 해당 필드에 넣는다.
						document.getElementById("roadAddress").value = roadAddr;
						document.getElementById("jibunAddress").value = data.jibunAddress;

					}
				}).open();
	}	//execDaumPostcode() 끝
</script>
<body>
	<c:if test="${session.user_email != null}">
		<c:set var="user_email" property="${session.user_email}" />
	</c:if>
	<c:if test="${user_email == null}">
		<script type="text/javascript">
			alert("로그인 후 이용할 수 있습니다.");
			location.href = "./loginPage.um";
		</script>
	</c:if>
	<c:if test="${user_email != null}">
		<h1>맛집 등록하기</h1>
		<form action="./insertFoodPro.fo" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td>작성자</td>
					<td>${user_email}</td>
				</tr>
				<tr>
					<td>맛집 이름</td>
					<td>
						<input type="text" name="f_name" id="f_name" required="required" placeholder="ex)아이티윌 돈까스...">
					</td>
				</tr>
				<tr>
					<td>맛집 테마</td>
					<td>
						<input type="radio" name="f_group" id="kr" value="1">한식
						<input type="radio" name="f_group" id="ch" value="2">중식
						<input type="radio" name="f_group" id="we" value="3">양식
						<input type="radio" name="f_group" id="jp" value="5">일식
						<input type="radio" name="f_group" id="sk" value="6">분식
						<input type="radio" name="f_group" id="cf" value="4">카페 <br>
						<span>[부산의 맛]</span>
						<input type="radio" name="f_group" id="bssm" value="7">횟집
						<input type="radio" name="f_group" id="bmil" value="8">밀면
						<input type="radio" name="f_group" id="bpgb" value="9">돼지국밥
					</td>
				</tr>
				<tr>
					<td>추천하는 메뉴</td>
					<td>
						<input type="text" name="f_menu" id="f_menu" placeholder="ex)IT왕돈까스..">
					</td>
				</tr>
				<tr>
					<td>맛집 설명</td>
					<td>
						<textarea rows="5" cols="60" name="f_content" id="f_content" placeholder="방문했던 맛집에 대해 상세히 말씀해주세요! (4000자 이내)"></textarea>
					</td>
				</tr>
				<tr>
					<td>맛집 이미지</td>
					<!-- 메인이미지 -->
					<td><input type="file" name="f_img"></td>
					<!-- http://bigmark.tistory.com/28 참고 -->
				</tr>
				<tr>
					<td><a onclick="execDaumPostcode();">주소검색(클릭)</a></td>
				</tr>
				<tr>
					<td>
						<input type="text" id="roadAddress" placeholder="도로명주소" name="addr1" class="form-control" readonly><br>
						<input type="text" id="jibunAddress" placeholder="지번주소" name="addr2" class="form-control"  readonly><br>
						<input type="text" id="detailAddress" placeholder="상세주소" name="addr3" class="form-control">
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="업로드"></td>
				</tr>
			</table>
			<h2>추가 이미지업로드</h2>
			<table id="detailImg">
				<tr>
					<td>메인이미지[선택시 서브이미지 선택할수있게나옴]</td>
					<td id="appendTd">
						<input type="file" name="f_img1" id="imgname">
					</td>
				</tr>
			</table>
			<div id='subimg'></div>
		</form>
	</c:if>
</body>
</html>