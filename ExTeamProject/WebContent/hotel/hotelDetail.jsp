<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

<link rel="stylesheet" href="/ExTeamProject/css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="/ExTeamProject/css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="/ExTeamProject/css/bootstrap.css">
	<!-- Owl Carousel -->
	<link rel="stylesheet" href="/ExTeamProject/css/owl.carousel.min.css">
	<link rel="stylesheet" href="/ExTeamProject/css/owl.theme.default.min.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="/ExTeamProject/css/style.css">
	
	
<style>
	
	
	<!--방 이미지가 뿌려지는공간 -->
	html,body{
		width: 100%;
		height: 100%:
	}
	
	.HotelMainDiv{	
		width:100%;
		height: 40%;
	}
	
	.HotelMainDiv img{
		width: 100%;
		height: 100%;
	}	
	
	.HotelMainDiv .MainImgDiv{
		width:50%;
		height:100%;
		display: inline-block;
		float : left;
	}
	
	.subImgDiv{
		width:25%;
		height:100%;
		display: inline-block;
		float : left;
	}
	
	.subImg{
		width: 100%;
		height : 50%;
		display : inline-block;
		float : left;
	}
	
	
	
	.HotelInfoDiv{	
		width:70%;
	}
	
	
	.MainHotelImgDiv{
		width : 100%;
		height : 30%;
	}
	
	.MainHotelImgDiv img{
		width : 100%;
		height : 30%;
	}
	
	.facilitiesDiv{
		width : 50%;
		display : inline-block;
		float : left;
	}
	
	
	<!--방정보-->
	.roomInfo{
		width:70%;
		display: flow-root; <!--뭔지 모르겠지만 이거하니됬다. -->
	}
	
	.roomMainImg{
		width:20%;
		display : inline-block;
		float : left;
	}
	
	.roomMainImg img{
		width:100%;
		height: 100%;
	}
	
	#roomInfo{
		width:70%;
		display: flow-root; <!--뭔지 모르겠지만 이거하니됬다. -->
	}
	
	#roomInfo2{
		width:70%;
		display: flow-root; <!--뭔지 모르겠지만 이거하니됬다. -->
	}
	
	#reservation{
		width: 95px;
		text-align: center;
		position: absolute;
		top: 100px;
		right: -96px;
	}
	
	
	

	

</style>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<jsp:include page="../header.jsp"/>
	<c:set var="hdto" value="${requestScope.hdto }"/>
	
	<c:set var="fdto" value="${requestScope.fdto }"/>
	
	<c:choose>
		<c:when test="${hdto == null }">
			<script>
			alert('정상적인 접근이 아니거나 해당 호텔의 정보가 삭제되었습니다.')
			</script>
		</c:when>
		
		
		
		
		<c:otherwise>
			<div class="HotelMainDiv">
				<div class="MainHotelImgDiv">
					<img src="hotel/${hdto.h_imgpath}${hdto.h_imgname}">
				</div>	 
			</div>
			
		<div class="container text-center">
		
			<div class="HotelInfoDiv">
					<h2>호텔이름 : ${hdto.h_name }아아아글자수채우기이이이이</h2>
					<h3>${hdto.h_bestcount }명이 해당 호텔을 추천했습니다!</h3>
					<p>호텔설명 : ${hdto.h_content }</p>
					<p>호텔주의사항 : ${hdto.h_caution }	</p>
					<p>호텔규칙 : ${hdto.h_rule }</p>
					<p>세부사항 : ${hdto.h_detail }</p>	
					
					<hr/>
				
				<h2 id="facilitiesMainH2">편의시설</h2>
				<c:if test="${fdto.wifi == 1 }">
					<div class="facilitiesDiv">
						<h3>${"와이파이" }</h3>
					</div>
				</c:if>
				<c:if test="${fdto.shampoo == 1 }">
					<div class="facilitiesDiv">
						<h3>${"샴푸무료제공 ..?" }</h3>
					</div>
				</c:if>
				<c:if test="${fdto.closet == 1 }">
					<div class="facilitiesDiv">
						<h3>${"옷장" }</h3>
					</div>
				</c:if>
				<c:if test="${fdto.tv == 1 }">
					<div class="facilitiesDiv">
						<h3>${"tv" }</h3>
					</div>
				</c:if>
				<c:if test="${fdto.aircon == 1 }">
					<div class="facilitiesDiv">
						<h3>${"에어컨" }</h3>
					</div>	
				</c:if>
				<c:if test="${fdto.hairdry == 1}">
					<div class="facilitiesDiv">
						<h3>${"헤어드라이기" }</h3>
					</div>	
				</c:if>
				<c:if test="${fdto.swim == 1 }">
					<div class="facilitiesDiv">
						<h3>${"수영장" }</h3>
					</div>
				</c:if>
				<c:if test="${fdto.wash_dry == 1 }">
					<div class="facilitiesDiv">
						<h3>${"세탁기" }</h3>
					</div>
				</c:if>
				<c:if test="${fdto.parking == 1 }">
					<div class="facilitiesDiv">
						<h3>${"주차장" }</h3>
					</div>
				</c:if>
				<c:if test="${fdto.elevator == 1 }">
					<div class="facilitiesDiv">
						<h3>${"엘리베이터" }</h3>
					</div>
				</c:if>
				<c:if test="${fdto.health == 1 }">
					<div class="facilitiesDiv">
						<h3>${"헬스장" }</h3>
					</div>
				</c:if>
				<c:if test="${fdto.etc != null }">
					<div class="facilitiesDiv">
						<p>${fdto.etc }</p>
					</div>
				</c:if>
					<hr>		
		</div><!-- 편의시설 종료 -->
		
		
		<div id="roomInfo">	
				
					<hr>							
					<h2>방정보</h2>
					<p>클릭시 방정보와 서브이미가 나옴</p>
		</div>
				<!-- 페이징처리해야함! -->
				<!-- 지금은 임의로 5개 만들어놨음 나중에 1개만  -->	
			<c:forEach var="room" items="${requestScope.rlist }">
				<!-- ajax에 서브이미지를 가져오기 위한 data값을 전달하기위해 셋팅 -->
				<c:set var ="h_rno" value="${room.h_rno }"/>
				<div class="roomMainImg">
					<img src="hotel/${room.imgpath }${room.imgname}">
				</div>
				<div class="roomMainImg">
					<img src="hotel/${room.imgpath }${room.imgname}">
				</div>
				<div class="roomMainImg">
					<img src="hotel/${room.imgpath }${room.imgname}">
				</div>
				<div class="roomMainImg">
					<img src="hotel/${room.imgpath }${room.imgname}">
				</div>
				<div class="roomMainImg">
					<img src="hotel/${room.imgpath }${room.imgname}">
				</div>
				
			</c:forEach>	
		</div> <!-- 컨테이너 종료 -->
		
			
		
		<%-- ajax를 통해 뿌려주는 부분 --%>
			<div class="HotelMainDiv" >
				
				<div class="MainImgDiv" id="img1">
					<!-- 메인이미지 들어갈곳 -->
				</div>
				
				<div class="subImgDiv">
					<div class="subImg" id="img2">
						<!-- 서브이미지 들어갈곳 -->	
					</div>
					<div class="subImg" id="img3">
						<!-- 서브이미지 들어갈곳 -->
					</div>
				</div>
				
				<div class="subImgDiv">
					<div class="subImg" id="img4">
						<!-- 서브이미지 들어갈곳 -->
					</div>
					<div class="subImg" id="img5">
						<!-- 서브이미지 들어갈곳 -->
					</div>
				</div>
				
				<hr/>
			</div>
			
			<div class="container text-center">
				<div id="roomInfo2">	
				<%-- ajax를 통해 뿌려주는부분 --%>			
				</div>
			</div>
			<%-- 종료 --%>
			
			<div id="reservation">
				ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ
				ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ
				ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ
				ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ
				ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ
				ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ
				
			</div>
			
		
				 
		</c:otherwise>
		
	</c:choose>	
	
	
		
	
	
	

		
</body>

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	
	<script type="text/javascript">
	
		<%-- ajax처리를 통한 서브이미지 들고오기 --%>
		$(function(){
			
			
			var defalutTop = parseInt($("#reservation").css("top"));
			//브라우저 (window)에 스크롤바가 이동될때마다.. (이벤트가 실행될때마다)
			  $(window).on("scroll",function(){
				  //스크롤바가 이동될때마다 스크로라의 이동 높이값을 반환하여 scv변수에 저장 
				  var scv = $(window).scrollTop();
				  
				  
				  //scroll바가 이동될때마다 <div id = "quick_menu">태그에 animate 메서드가 적용 
				  //이때 scv변수값(스크롤바의 이동 높이값)을 top속성에 적용하여
				  //1초만에 scroll바 이동 거리만큼 <div id = "quick_menu">태그가 이동되도록 함.
				  //그리고 (index.html 처음 실행 했을때 문서 상단에서 퀵 메뉴의 여백거릿값)
				  //defaultTop변수의 값을 더하여 상단에서 여백 거리만큼 떨어져서 이동되도록 함
				  //이때 방문자가 스크롤을 위 아래로 계속해서 움직이면 애니메이트 메서드가 여러번 작동되어
				  //큐에 에니메이트 메서드가 많이 쌓이게 되는데,
				  //이를 방지 하기 위해서 stop()메서드를 적용하여 앞서 적용된 에니메이트 메소드는 정지되도록 해야함
				  $("#reservation").stop().animate({top : scv+defalutTop+"px"},1000)
				  
				  
			  })
			
			$(".roomMainImg img").on("click",function(){
				var roomInfo = $("#roomInfo2");
				<%-- ajax Json방식으로 주고받을때 ... 연구중 삭제 하셔도됩니다!~
				var obj = new Object;
				var h_rno = ${h_rno};
				json.h_rno = h_rno;
				var jsonData = JSON.stringify(json)--%>
					var h_rno = ${h_rno};
					$.ajax({
						type : "post",
						url : "BringRoomSubImg.hotel",
						data : {
							h_rno : h_rno
						},
						dataType :'json',
						
						success : function(roomsubimg){
							var imgpath = roomsubimg.imgpath;
							var imgname = roomsubimg.imgname.split(',');
							$("#img1").html("<img src='hotel/"+imgpath+imgname[0]+"'>");
							$("#img2").html("<img src='hotel/"+imgpath+imgname[1]+"'>");
							$("#img3").html("<img src='hotel/"+imgpath+imgname[2]+"'>");
							$("#img4").html("<img src='hotel/"+imgpath+imgname[3]+"'>");
							$("#img5").html("<img src='hotel/"+imgpath+imgname[4]+"'>");
							//위에 작업이후 roomInfo가 필요하다는걸 느껴서 변수는 그냥 roomsubimg로 통일했습니다. -> 실제로는 room정보도 같이넘어옵니다~
							//action참고
							roomInfo.html("침대개수 : "+roomsubimg.bed);
							roomInfo.append("화장실개수 : "+roomsubimg.bathroom);
							roomInfo.append("방의 갯수 : "+roomsubimg.roomsize+"<br>");
							roomInfo.append("<h2>주중가 : "+roomsubimg.weekprice+"</h2><br>");
							roomInfo.append("<h2>주말가 : "+roomsubimg.weekend_price+"</h2>");
						},
						error : function(err){
							alert("에러");
						}
						
																		
						
					});
			});
			
			
			
		});
		
		
	
	</script>
</html>