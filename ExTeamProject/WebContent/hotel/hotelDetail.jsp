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
		width:80%;
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
		width:80%;
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
		width:80%;
		display: flow-root; <!--뭔지 모르겠지만 이거하니됬다. -->
	}
	
	
	

	

</style>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div id="ck">
	dd
	
</div>
request.setAttribute("hdto", hdto);
		request.setAttribute("fdto", fdto);
		request.setAttribute("rlist", rlist);
		
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
				<%-- 
					int h_no;
					int h_rno;
					int personne;
					int bed;
					int bathroom;
					String roomsize;
					int weekprice;
					int weekend_price;
					String imgpath;
					String imgname;
				 --%>
			</c:forEach>	
		</div> <!-- 컨테이너 종료 -->
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
			
			</div>
		
		</c:otherwise>
		
	</c:choose>	
	
	
		
	
	
	

		
</body>

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	
	<script type="text/javascript">
	
		<%-- ajax처리를 통한 서브이미지 들고오기 --%>
		$(function(){
			
			
			$(".roomMainImg img").on("click",function(){
				
				<%--var obj = new Object;
				
				
				
				var h_rno = ${h_rno};
				
				json.h_rno = h_rno;
				
				var jsonData = JSON.stringify(json)
				--%>
					var h_rno = ${h_rno};
					alert("h_rno값 : " + h_rno);
					$.ajax({
						type : "post",
						url : "whyare.hotellllllll",
						data : {
							h_rno : h_rno
						},
						dataType :'json',
						
						success : function(roomsubimg){
							$("#ck").append("ㅎㅇ");
							var imgpath = roomsubimg.imgpath;
							var imgname = roomsubimg.imgname.split(',');
							$("#img1").html("<img src='hotel/"+imgpath+imgname[0]+"'>");
							$("#img2").html("<img src='hotel/"+imgpath+imgname[1]+"'>");
							$("#img3").html("<img src='hotel/"+imgpath+imgname[2]+"'>");
							$("#img4").html("<img src='hotel/"+imgpath+imgname[3]+"'>");
							$("#img5").html("<img src='hotel/"+imgpath+imgname[4]+"'>");
						},
						error : function(err){
							alert("에러");
						}
						
																		
						
					});
			});
			
			
			
		});
		
		
	
	</script>
</html>