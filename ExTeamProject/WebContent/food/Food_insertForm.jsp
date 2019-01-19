<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> <!-- 다음주소찾기 ... -->
<script>

<%--팝업창을 이용한 찾기를 가져옴--%>

$(function(){
	$("#room input[type=file]").on("change",function(){
		
		
		
		$("#subimg").html("서브이미지 선택!! 최대5개 ");
		
		for(var i=2; i<7; i++ ){
		var file = "<input type='file' name='h_img"+i+"'>";
		$("#subimg").append(file);
		}
		
	});
	
})

function execDaumPostcode() {
    	new daum.Postcode({ 
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                
                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("roadAddress").value = roadAddr;
                document.getElementById("jibunAddress").value = data.jibunAddress;
                
            }
        }).open();
    }

</script>
<body>
	<h1> 맛집 등록하기</h1>
	<form action="./Insertfood.fo" method="post" enctype="multipart/form-data">
	
	
	<table>
	
			
			<tr>
				<td>맛집 이름</td>
				<td><input type="text" name="f_name" id="f_name" required="required"></td>
			</tr>
			<tr>
				<td>맛집 설명</td>
				<td><input type="text" name="f_content" id="f_content"></td>
			</tr>
			<tr>
				<td>추천하는 메뉴</td>
				<td><input type="text" name="f_menu" id="f_menu"></td>
			</tr>
			
			<tr>
				<td>세부사항</td>
				<td><input type="text" name="f_detail" id="f_detail"></td>
			</tr>
			<tr>
				<td>맛집 이미지</td> <!-- 메인이미지 -->
				<td><input type="file" name="f_img0"> </td>
				<!-- http://bigmark.tistory.com/28 참고 -->
			</tr>
			
			
			<!-- 
				추후수정 -> 서브이미지파일 받는것 -> 다중업로드 -> 
			
			 -->
			 <tr>
			 	<td><a onclick="execDaumPostcode();">주소찾기</a></td>
			 </tr>
			
			<tr> 
				<td><input type="text" id="roadAddress" placeholder="도로명주소" readonly name="addr1" class="form-control"><br>
				<input type="text" id="jibunAddress" placeholder="지번주소" readonly name="addr2" class="form-control"><br>  
				<input type="text" id="detailAddress" placeholder="상세주소" name="addr3" class="form-control">
				</td>
				
			</tr> 
		
			<tr>
				<td>맛집 테마</td>
				<td>
					<input type="checkbox" name="wifi" id="wifi" value="1">한식
					<input type="checkbox" name="tv" id="tv" value="1">중식
					<input type="checkbox" name="aircon" id="aircon" value="1">양식
					<input type="checkbox" name="wash_dry" id="wash_dry" value="1">카페
					<input type="checkbox" name="closet" id="closet" value="1">일식
					<input type="checkbox" name="shampoo" id="shampoo" value="1">분식				
				</td>
			</tr>
			<tr>
				<td>부산의 맛</td>
				<td>
					<input type="checkbox" name="hairdry" id="hairdry" value="1">횟집
					<input type="checkbox" name="parking" id="parking" value="1">밀면
					<input type="checkbox" name="elevator" id="elevator" value="1">돼지국밥
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="업로드"></td>
			</tr>
			
		
			
			
	</table>
	
	
		<h2>추가 이미지업로드</h2>
		<table id="room">
			<tr>
				
				<td>메인이미지[선택시 서브이미지 선택할수있게나옴]</td>
				<td id="appendTd"><input type="file" name="f_img1" id="imgname" ></td>
				
			</tr>
	
		
		</table>
		
		<div id='subimg'></div>
	</form>
	
	





</body>
</html>