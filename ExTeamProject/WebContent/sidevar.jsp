<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">
	<!-- Owl Carousel -->
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">
	<!-- Theme style  -->
	<link rel="stylesheet" href="css/style.css">
	<!-- 다음 지도관련 css -->
	<link rel="stylesheet" href="css/DaumMap.css">
	
	
	<!-- 토글버튼 css -->
	<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">

	<!-- Modernizr JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script src="js/modernizr-2.6.2.min.js"></script>
	
	
	
	
	
	
	
	<script>
		<!-- 지도 온오프시 -->
	$(function(){
			
		 $("#Daum_map").hide();
		
		$('#chmap').change(function() {
			  var ckmap = ($(this).prop('checked'));	//자바스크립트의 속성을 가져옴
			  
			  if(ckmap){
				  $("#Daum_map").show();
			  }else{
				  $("#Daum_map").hide();
			  }
		});
		
		
		// 지도옵션 선택(ajax처리)
		$("input[name='ckopt']").on("change",function(){
			
			var ckopt = $(this).val();
			
			if(ckopt==1){	//맛집
				alert('맛집');
			
			}else if(ckopt==2){	//관광지
				alert('관광지');
			}else if(ckopt==3){	//호텔
				alert('호텔');
			
				
			/*
				
			
			*/
			}
			
		});
		
	});
	</script>

</head>
<body>
	<!-- sidebar -->
	<div id="fh5co-page">
		<a href="#" class="js-fh5co-nav-toggle fh5co-nav-toggle"><i></i></a>
		<aside id="fh5co-aside" role="complementary" class="border js-fullheight">

		<div class="text-center">
			<h1>지도검색</h1>
			<label class="checkbox-inline">
			<input id="chmap" type="checkbox" data-toggle="toggle">
			</label>
		</div>
		<div class="text-center">
			<input type="checkbox" name="ckopt" value="1">맛집
			<input type="checkbox" name="ckopt" value="2">관광지
			<input type="checkbox" name="ckopt" value="3">호텔
		</div>
		<br>
			<nav id="fh5co-main-menu" role="navigation">
				<ul>
					<li class="fh5co-active"><a href="index.html">Home</a></li>
					<li><a href="portfolio.html">Portfolio</a></li>
					<li><a href="about.html">About</a></li>
					<li><a href="contact.html">Contact</a></li>
				</ul>
			</nav>

			<div class="fh5co-footer">
				<p><small>&copy; 2016 Nitro Free HTML5. All Rights Reserved.</span> <span>Designed by <a href="http://freehtml5.co/" target="_blank">FreeHTML5.co</a> </span> <span>Demo Images: <a href="http://unsplash.com/" target="_blank">Unsplash</a></span></small></p>
				<ul>
					<li><a href="#"><i class="icon-facebook"></i></a></li>
					<li><a href="#"><i class="icon-twitter"></i></a></li>
					<li><a href="#"><i class="icon-instagram"></i></a></li>
					<li><a href="#"><i class="icon-linkedin"></i></a></li>
				</ul>
			</div>

		</aside>
	
			 <!-- 다음 api지도 -->	
		<div id="Daum_map" class="col-md-12"></div>
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=906e68dba1adb50425e650ad46575c5b"></script>
			<script>
				var container = document.getElementById('Daum_map');
				var options = {
					center: new daum.maps.LatLng(35.17944, 129.07556), //최초 위치 부산으로 설정
					level: 5
				};
		
				var map = new daum.maps.Map(container, options);
	</script>
	
	
	</div>	
		<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- Stellar -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Counters -->
	<script src="js/jquery.countTo.js"></script>
	
	<%-- 토글 버튼을 위한 링크 --%>
	<!--     인덱스에서 작업할때 충돌 일어남 평소 주석
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
	<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
	 -->
	
	<!-- MAIN JS -->
	<script src="js/main.js"></script>
		
</body>
</html>