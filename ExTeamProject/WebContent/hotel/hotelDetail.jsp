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
	
	<!-- 현재 페이지 css -->



<style>
	/*%기준을 잡기위한 html,body*/
	html,body{
		width: 100%;
		height: 100%:
	}
	
	/*호텔 사진과 정보가 들어가는 제일큰 DIv*/
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
		width:65%;
		display: inline-block;
	}
	
	
	.MainHotelImgDiv{
		width : 70%;
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
		width:65%;
		display: flow-root; /*뭔지 모르겠지만 이거하니됬다.*/
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
		width:65%;
		display: flow-root; /*뭔지 모르겠지만 이거하니됬다.*/ 
	}
	
	#roomInfo2{
		width:65%;
		display: flow-root; /*뭔지 모르겠지만 이거하니됬다.*/
	}
	
	
	
	#reservation{
		width: 35%;
		height: 100%;
		text-align: center;
		display : inline-block;
		float :right;
		border: 1px solid red;
	}
	
	#reservation input{
		width:45%;
	}

</style>	

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		
		<jsp:include page="../header.jsp"/>
	
	
	<c:set var="hdto" value="${requestScope.hdto }"/>
	
	<c:set var="fdto" value="${requestScope.fdto }"/>
	
	<c:if test="${udto !=null }">
		<c:set var ="udto" value="${requestScope.udto}" />
	</c:if>
	
	
	<c:choose>
		<c:when test="${hdto == null }">
			<script>
			alert('정상적인 접근이 아니거나 해당 호텔의 정보가 삭제되었습니다.')
			</script>
		</c:when>
		
		
		
		
		<c:otherwise>
		<!-- 예약시에 사용될 h_no 셋팅 -->
		<c:set var="h_no" value="${hdto.h_no }"/>
			<div class="HotelMainDiv">
				<div class="MainHotelImgDiv">
					<img src="hotel/${hdto.h_imgpath}${hdto.h_imgname}">
				</div>	 
			</div>
			
		<div class="container">
		
			<div class="HotelInfoDiv">
					<h2>호텔이름 : ${hdto.h_name }아아아글자수채우기이이이이</h2>
					<h3>${hdto.h_bestcount }명이 해당 호텔을 추천했습니다!</h3>
					<p>호텔설명 : ${hdto.h_content }</p>
					<p>호텔주의사항 : ${hdto.h_caution }	</p>
					<p>호텔규칙 : ${hdto.h_rule }</p>
					<p>세부사항 : ${hdto.h_detail }</p>	
					
					<hr/>
					
			</div>		
			
			<div id="reservation">
						
						
						<c:choose>
							
							<c:when test="${sessionScope.user_email !=null }">
							<h2>가격 </h2>
							<span id="price"></span>
							날짜<br>
							<form>
							<input type="text" placeholder="체크인" id="ckindate"> -> <input type="text" placeholder="체크아웃" id="ckoutdate">
							예약자는 : ${udto.user_email } <br>
							인원<br>
							<input type = "hidden" name="h_no" value="">
							<input type = "hidden" name="h_rno" value=""><!-- ajax사용해서 값을 지정합니다 -->
							<input type = "hidden" name="user_no" value="${udto.user_no }">
							<select name="personnel" >
							</select>
							<button>예약하기</button><br>
							<input type = "hidden" name="total_price" value="">
							<!-- 날짜선택시 표시될 총 가격이 들어갈공간 -->
							</form>
							<span id="total_price"></span>
							</c:when>
							<c:otherwise>
							로그인되지 않았습니다 로그인을 해주세요
							</c:otherwise>
						</c:choose>	
						<br>
						
							
						총가격은 ... : ajax사용						
					</div>
					
					
				<div class="HotelInfoDiv">
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
			
			<c:if test="${requestScope.udto != null }">
				$
			</c:if>
			
<<<<<<< HEAD
			<%--댓글달기 --%>
			<div id="commList">
				아이디 <input text="text"	id="user_no">
				댓글 <textarea rows="3" cols="30" id="content"></textarea>
				
				<br>
				<input type="button" value="등록" onclick="addcomments()"/>
				
			</div>
			
			<c:if test="${requestScope.udto !=null }">
			
			</c:if>
			
		
				 
		</c:otherwise>
		
	</c:choose>	
	
</body>


<!-- jquery 및 jquery ui -->
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
	<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
	<script type="text/javascript">
	
		<%--댓글 관련 function--%>
		function getXHR(){
			if(window.XMLHttpRequest){
				return new XMLHttpRequest();
			}else{
				return new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		
		var xhr=null;
		function addComments(){
			
			//1. xhr객체 얻기
			xhr = getXHR();
			
			//2.콜백 메소드 설정하기 
			xhr.onreadystatechange=callback;
			
			//3. open함수로 초기화 설정
			xhr.open("POST","comm.do?cmd=insert",true);
			
			//4. send함수로 서버에 요청(post방식일 때)
			xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			
			//사용자가 입력한 아이디와 댓글 얻어오기
			
			var user_no = document.getElementById("user_no").value;
			var h_c_no =document.getElementById("h_c_no").value;
			
			var param="user_no="+user_no+"&h_c_no="+h_c_no;
			
			//send메소드를 호출하면서 파라미터 전송하기
			xhr.send(param);
		}
		
			function callback(){
				if(xhr.readyState ==4 && xhr.status==200){
					var xml=xhr.responseXML;
					var result=xml.getElementsByTagName("info")[0].firstChild.nodeValue;
					
					if(result == "success"){ 
						alert('등록 성공');
						getList();
					}else{
						alert('등록 실패');
					}
				}//if문 끝
			}//callback() end
			
			function getList(){
				xhr=getXHR();
				xhr.onreadystatechange = showList;
				xhr.open("get","comm.do?cmd=list",true);
				xhr.send(null);
			}
		
			//댓글 div안의 내용들 제거 메소드
			function listRemove(){
				
				//commList의 자식 div갯수 얻어오기(컬렉션 타입)
				var childs = document.getElementById("commList").childNodes;
				
				//commList의 자식 div들 제거하기
				for(var i=child.length -1; i>=0; i--){
					
					//childs배열의 i번째 요소 참조값 얻어오기
					var char=childs.item(i);
					
					//commList에서 child제거하기
					document.getElementById("commList").removeChild(child);
				}
			} //listRemove() end
		
			
			//가져온 데이터를 개행하기 위해서는 \n을 <br>로 바꾸는 메서드(textarea에서 개행은 \n으로 db에 저장)
			// str1문자열에서 str2를 str3로 바꾸기. replace(str1, str2, str3)
			function replace(str1, str2, str3){
				var ch="";
				var chstr="";
				for(var i=0; i<str1.length; i++){
					ch=str1.charAt(i);
					
					if(ch==str2){ //str2: '\n'
						chstr=chstr+str3;
					}else{
						chstr=chstr+ch;
					}
				}
				return chstr;
			}
			
			
			//정상적으로 작동하면(chr.readyState==4 && xhr.status==200)
			//기존 화면의 <div>삭제하고 불러와 표시
			
			function showList(){
				if(xhr.readyState == 4 && xhr.status ==200){
					//commList의 자식 div모두 제거
					listRemove();
					
					var xml = xhr.responseXML;
					var len=xml.getElementsByTagName("user_no").length;
					
					if(len>0){
						for(var i=0; i<len; i++){
							var id=xml.getElementsByName("user_no")[i].firstChild.nodeValue;
							var comments = xml.gegetElementsByTagName("content")[i].firstChild.nodeValue;
							
							comments = replace(comments, '\n','<br>');
							var txt = "작성자 : "+ id + "<br>"+ "댓글 : " +comments;	
							
							
							//내용을 담을 div생성하기
							var div=document.createElement("div");
							
							//생성된 div에 내용 담기
							div.innerHTML=txt;
							div.style.width="300px";
							div.style.height="80px";
							div.style.border="1px solid blue";
							div.style.marginTop="8px";
							
							
							//전체 댓글을 담을 div의 참조값 얻어오기
							var commList = document.getElementById("commList");
							
							//댓글 div에 생성된 div추가하기
							commList.appendChild(div);
						}
					}
					
					
				}
			}
			
			
	
		<%-- ajax처리를 통한 서브이미지 들고오기 --%>
		$(function(){
			
			// 나중에 주말가 주중가 구분하여 계산하는 식 작성 현재는 주중가로 취급
			var total_price;
			var ckin_date="";
			//날짜 -> 숫자 변환시 임시로 담을 저장소 
			var ckin_temp;
			var ckout_date="";
			//날짜 -> 숫자 변환시 임시로 담을 저장소
			var ckout_temp;
			
			
			
			/*jquery ui (예약날짜관련)*/
			var   minDate = new Date();
		      $("#ckindate").datepicker({
		         showAnim: 'drop',
		         numberOfMonth: 1,
		         minDate: minDate,
		         dateFormat:'yy-mm-dd',
		         onClose:function(selectedDate){
		            $('#ckin').datepicker("option","minDate",selectedDate);
		            // 총가격을 구하기위한 처리
		            
		            ckin_temp = selectedDate.split("/");
		            for(var i = 0; i<ckin_temp.length; i++){
		            	ckin_date += (ckin_temp[i]);
		            }
		            var year = ckin_date.substr(0,2);
		            var month = ckin_date.substr(2,2);
		            var day = ckin_date.substr(4,2);
		            ckin_date = new Date(year, month, day);

		            //alert(typeof ckin_date);
		         }
		      });
		      
		      $("#ckoutdate").datepicker({
		         showAnim: 'drop',
		         numberOfMonth: 1,
		         minDate: minDate,
		         dateFormat:'yy-mm-dd',
		         onClose:function(selectedDate){
		            $('#ckout').datepicker("option","maxDate",selectedDate);
		            
		            ckout_date = selectedDate.split("/");
		            alert(ckout_date)
		            
		            alert(ckout_date - ckin_date);
		         }
		      });
		/* jquery ui (예약날짜관련 종료)*/
			
			// forEach 반복마다 h_rno값을 셋팅해놓았습니다. 밑에 ajax(방정보)와 예약시에 사용합니다.
			var h_no = ${h_no};
			var h_rno = ${h_rno};
			
			
			
			$(".roomMainImg img").on("click",function(){
				var roomInfo = $("#roomInfo2");
				
				<%-- ajax Json방식으로 주고받을때 ... 연구중 삭제 하셔도됩니다!~
				var obj = new Object;
				var h_rno = ${h_rno};
				json.h_rno = h_rno;
				var jsonData = JSON.stringify(json)--%>
					
					$.ajax({
						type : "post",
						url : "BringRoomSubImg.hotel",
						data : {
							h_rno : h_rno
						},
						dataType :'json',
						
						success : function(roomsubimg){
							
							//서브이미지넣는 
							var imgpath = roomsubimg.imgpath;
							var imgname = roomsubimg.imgname.split(',');
							$("#img1").html("<img src='hotel/"+imgpath+imgname[0]+"'>");
							$("#img2").html("<img src='hotel/"+imgpath+imgname[1]+"'>");
							$("#img3").html("<img src='hotel/"+imgpath+imgname[2]+"'>");
							$("#img4").html("<img src='hotel/"+imgpath+imgname[3]+"'>");
							$("#img5").html("<img src='hotel/"+imgpath+imgname[4]+"'>");
							//위에 작업이후 roomInfo가 필요하다는걸 느껴서 변수는 그냥 roomsubimg로 통일했습니다. -> 실제로는 room정보도 같이넘어옵니다~
							//action참고
							//방정보넣는곳
							roomInfo.html("침대개수 : "+roomsubimg.bed);
							roomInfo.append("화장실개수 : "+roomsubimg.bathroom);
							roomInfo.append("방의 갯수 : "+roomsubimg.roomsize+"<br>");
							roomInfo.append("<h2>주중가 : "+roomsubimg.weekprice+"</h2><br>");
							roomInfo.append("<h2>주말가 : "+roomsubimg.weekend_price+"</h2>");
							
							//예약관련 정보넣는곳
							$("#reservation #price").html("현재 선택하신 호텔의 주중가는 :"+roomsubimg.weekprice+"원 입니다.<br>");
							$("#reservation #price").append("주말가는 : "+roomsubimg.weekend_price+"원 입니다<br>");
							
							var roomsize = roomsubimg.roomsize;
							
							if(roomsize == "싱글"){
								$("#reservation [name='personnel']").html("<option value='1'>1명</option>");
								$("#reservation [name='personnel']").append("<option value='2'>2명</option>");
							}else if(roomsize == "더블" || roomsize == "트윈"){
								$("#reservation [name='personnel']").html("<option value='1'>1명</option>");
								$("#reservation [name='personnel']").append("<option value='2'>2명</option>");
								$("#reservation [name='personnel']").append("<option value='3'>3명</option>");
								$("#reservation [name='personnel']").append("<option value='4'>4명</option>");
							}else {
								$("#reservation [name='personnel']").html("<option value='1'>1명</option>");
								$("#reservation [name='personnel']").append("<option value='2'>2명</option>");
								$("#reservation [name='personnel']").append("<option value='3'>3명</option>");
								$("#reservation [name='personnel']").append("<option value='4'>4명</option>");
								$("#reservation [name='personnel']").append("<option value='5'>5명</option>");
								$("#reservation [name='personnel']").append("<option value='6'>6명</option>");
							}
							
							/* 예약관련 type이 hidden 곳에 value값 셋팅하는곳*/
							$("#reservation [name='h_rno']").val(roomsize.h_rno);
							$("#reservation [name='h_no']").val(roomsize.h_no);
							
						},
						error : function(err){
							alert("에러");
						}
						
					});
			});
			
			//예약버튼 클릭시..
			$("#reservation button").on("click",function(){
				
			});
			
		});
	
	</script>
</html>