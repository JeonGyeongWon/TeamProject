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
<script
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=906e68dba1adb50425e650ad46575c5b&libraries=services"></script>

<!-- 다음주소찾기 ... -->
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
		<form action="./insertFoodPro.fo" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td>작성자</td>
					<td>${user_email}</td>
				</tr>
				<tr>
					<td>맛집 이름</td>
					<td><input type="text" name="f_name" id="f_name" required="required" placeholder="ex)아이티윌 돈까스..."></td>
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
			</table>
			
			<!-- 다음지도 -->
			<input type="text" id="sample5_address" placeholder="주소" style="width: 1000px;" name="f_addr">
			<input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색">	<br>
			<div id="map" style="width: 300px; height: 300px; margin-top: 10px; display: none"></div>
			<script>
				$(function() {
					var wedo;
					var gyungdo;
				});
				var mapContainer = document.getElementById('map'), // 지도를 표시할 div
				mapOption = {
					center : new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
					level : 5
				// 지도의 확대 레벨
				};

				//지도를 미리 생성
				var map = new daum.maps.Map(mapContainer, mapOption);
				//주소-좌표 변환 객체를 생성
				var geocoder = new daum.maps.services.Geocoder();
				//마커를 미리 생성
				var marker = new daum.maps.Marker({
					position : new daum.maps.LatLng(37.537187, 127.005476),
					map : map
				});

				function sample5_execDaumPostcode() {
					new daum.Postcode(
						{oncomplete : function(data){
								var addr = data.address; // 최종 주소 변수
								// 주소 정보를 해당 필드에 넣는다.
								document.getElementById("sample5_address").value = addr;
								// 주소로 상세 정보를 검색
								geocoder.addressSearch(data.address, function(results, status) {
									// 정상적으로 검색이 완료됐으면
									if (status === daum.maps.services.Status.OK) {
										var result = results[0]; //첫번째 결과의 값을 활용

										// 해당 주소에 대한 좌표를 받아서
										var coords = new daum.maps.LatLng(result.y,result.x);	// 지도를 보여준다.

										// 위도, 경도 값을 가져옴
										gyungdo = result.y;
										wedo = result.x;
										$("#wedo").val(wedo);
										$("#gyungdo").val(gyungdo);
										alert($("#wedo").val());
										alert($("#gyungdo").val());
										mapContainer.style.display = "block";
										map.relayout();
										// 지도 중심을 변경한다.
										map.setCenter(coords);
										// 마커를 결과값으로 받은 위치로 옮긴다.
										marker.setPosition(coords)
									}
								});
							}
						}).open();
				}
			</script>
			<!-- 위도 -->
			<input type="hidden" id="wedo" name="f_addr_latitude" value="">
			<!-- 경도 -->
			<input type="hidden" id="gyungdo" name="f_addr_longitude" value="">
			<input type="submit" value="업로드">
		</form>
	</c:if>
</body>
</html>