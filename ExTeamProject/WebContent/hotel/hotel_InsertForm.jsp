<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 호텔로 등록하기</h1>
	<form action="InsertHotel.hotel" method="post" enctype="multipart/form-data">
	<table>
	
	h_name
	h_content
	h_addr
	h_caution
	h_rule
	h_detail
	h_regdate
	h_img
			
			<tr>
				<td>호텔 이름</td>
				<td><input type="text" name="h_name" id="h_name" required="required"></td>
			</tr>
			<tr>
				<td>호텔 설명</td>
				<td><input type="text" name="h_content" id="h_content"></td>
			</tr>
			<tr>
				<td>호텔 주소</td>
				<td><input type="text" name="h_addr" id="h_addr"></td>
			</tr>
			<tr>
				<td>주의사항</td>
				<td><input type="text" name="h_caution" id="h_caution"></td>
			</tr>
			<tr>
				<td>이용규칙</td>
				<td><input type="text" name="h_rule" id="h_rule"></td>
			</tr>
			<tr>
				<td>세부사항</td>
				<td><input type="text" name="h_detail" id="h_detail"></td>
			</tr>
			<tr>
				<td>호텔 이미지</td> <!-- 메인이미지 -->
				<td><input type="file" name="h_img"> <input type="submit" value="업로드"></td>
				<!-- http://bigmark.tistory.com/28 참고 -->
			</tr>
			
			<!-- 
				추후수정 -> 서브이미지파일 받는것 -> 다중업로드 -> 
			
			 -->
		
			<tr>
				<td>편의시설</td>
				<td>
					<input type="checkbox" name="wifi" id="wifi" value="true">무선인터넷
					<input type="checkbox" name="tv" id="tv" value="true">TV
					<input type="checkbox" name="aircon" id="aircon" value="true">에어컨
					<input type="checkbox" name="wash_dry" id="wash_dry" value="true">세탁기
					<input type="checkbox" name="closet" id="closet" value="true">옷장
					<input type="checkbox" name="shampoo" id="shampoo" value="true">욕실용품
					<input type="checkbox" name="hairdry" id="hairdry" value="true">헤어드라이어
					<input type="checkbox" name="parking" id="parking" value="true">건물 내 무료 주차
					<input type="checkbox" name="elevator" id="elevator" value="true">엘리베이터
					<input type="checkbox" name="swim" id="swim" value="true">수영장
					<input type="checkbox" name="health" id="health" value="true">피트니스센터
				</td>
			</tr>
	</table>
	</form>





</body>
</html>