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
	<h1> 호텔로 등록하기</h1>
	<form action="./InsertHotel.hotel" method="post" enctype="multipart/form-data">
	
	
	<table>
	
			
			<tr>
				<td>호텔 이름</td>
				<td><input type="text" name="h_name" id="h_name" required="required"></td>
			</tr>
			<tr>
				<td>호텔 설명</td>
				<td><input type="text" name="h_content" id="h_content"></td>
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
				<td><input type="file" name="h_img0"> </td>
				<!-- http://bigmark.tistory.com/28 참고 -->
			</tr>
			
			
			<!-- 
				추후수정 -> 서브이미지파일 받는것 -> 다중업로드 -> 
			
			 -->
			 <tr>
			 	<td><a onclick="execDaumPostcode();">주소찾기</a></td>
			 </tr>
			
		
			<tr>
				<td>편의시설</td>
				<td>
					<input type="checkbox" name="wifi" id="wifi" value="1">무선인터넷
					<input type="checkbox" name="tv" id="tv" value="1">TV
					<input type="checkbox" name="aircon" id="aircon" value="1">에어컨
					<input type="checkbox" name="wash_dry" id="wash_dry" value="1">세탁기
					<input type="checkbox" name="closet" id="closet" value="1">옷장
					<input type="checkbox" name="shampoo" id="shampoo" value="1">욕실용품
					<input type="checkbox" name="hairdry" id="hairdry" value="1">헤어드라이어
					<input type="checkbox" name="parking" id="parking" value="1">건물 내 무료 주차
					<input type="checkbox" name="elevator" id="elevator" value="1">엘리베이터
					<input type="checkbox" name="swim" id="swim" value="1">수영장
					<input type="checkbox" name="health" id="health" value="1">피트니스센터
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="업로드"></td>
			</tr>
			
		
			
			
	</table>
	
	
		<h2>방설정</h2>
		<table id="room">
			<tr>
				<td>적정인원</td>
				<td>
				<select name="personnel">
					<option value="2">2인이하</option>
					<option value="4">4인이하</option>
					<option value="6">6인이하</option>
					<option value="8">8인이상</option>
				</select>
				</td>
				<td>침대갯수</td>
				<td><input type="text" name="bed"></td>
				<td>화장실개수</td>
				<td><input type="text" name="bathroom"></td>
				<td>방사이즈</td>
				<td>
				<select name="roomsize">
					<option value="싱글">싱글</option>
					<option value="더블">더블</option>
					<option value="트윈">트윈</option>
					<option value="스위트">스위트</option>
				</select>
				</td>
				<td>주중가</td>
				<td><input type="text" name="weekprice"></td>
				<td>주말가</td>
				<td><input type="text" name="weekend_price"></td>
				
				<td>메인이미지[선택시 서브이미지 선택할수있게나옴]</td>
				<td id="appendTd"><input type="file" name="h_img1" id="imgname" ></td>
				
			</tr>
	
		
		</table>
		
		<div id='subimg'>
		
		</div>
		
		<input type="text" id="sample5_address" placeholder="주소" style="width:1000px;" name="addr">
<input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색"><br>


<div id="map" style="width:300px;height:300px;margin-top:10px;display:none"></div>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=906e68dba1adb50425e650ad46575c5b&libraries=services"></script>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>

$(function(){
	
	var wedo;
	var gyungdo;
	
	
});
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
            level: 5 // 지도의 확대 레벨
        };

    //지도를 미리 생성
    var map = new daum.maps.Map(mapContainer, mapOption);
    //주소-좌표 변환 객체를 생성
    var geocoder = new daum.maps.services.Geocoder();
    //마커를 미리 생성
    var marker = new daum.maps.Marker({
        position: new daum.maps.LatLng(37.537187, 127.005476),
        map: map
    });


    function sample5_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                var addr = data.address; // 최종 주소 변수

                // 주소 정보를 해당 필드에 넣는다.
                document.getElementById("sample5_address").value = addr;
                // 주소로 상세 정보를 검색
                geocoder.addressSearch(data.address, function(results, status) {
                    // 정상적으로 검색이 완료됐으면
                    if (status === daum.maps.services.Status.OK) {

                        var result = results[0]; //첫번째 결과의 값을 활용

                        // 해당 주소에 대한 좌표를 받아서
                        var coords = new daum.maps.LatLng(result.y, result.x);
                        // 지도를 보여준다.
                        
                        
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
	<input type="hidden" id="wedo" name="Latitude" value=""> <!-- 위도 -->
	<input type="hidden" id="gyungdo" name="Hardness" value=""> <!-- 경도 -->
	</form>
	
	
	
	





</body>
</html>