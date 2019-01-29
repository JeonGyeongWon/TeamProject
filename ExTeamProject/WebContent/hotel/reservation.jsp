<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

<script>
	function SMSAuth(){
		$.ajax({
			type : "post",
			url : "SMSAuth.hotel",
			data : {
				// 데이터값
			},
			dataType :'json',
			success : function(roomsubimg)
			
			
			)};
			
			

		
	

</script>

</head>
<body>
	<jsp:include page="../header.jsp"/>
	
	
	<!-- request.setAttribute("hdto", hdto);
		request.setAttribute("fdto", fdto);
		request.setAttribute("rdto", rdto);
		request.setAttribute("r_imgdto", r_imgdto);
		request.setAttribute("udto", udto);
		//예약창을 한번더 보여주기위해서 DB에 바로저장하지않고 해당정보만보내줌
		request.setAttribute("Re_dto", Re_dto); -->
	<div class="container text-center">
		
		<c:set var="hdto" value="${requestScope.hdto }"/>
		<c:set var="fdto" value="${requestScope.fdto }"/>
		<c:set var="rdto" value="${requestScope.rdto }"/>
		<c:set var="r_imgdto" value="${requestScope.r_imgdto }"/>
		<c:set var="udto" value="${requestScope.udto }"/>
		<c:set var="Re_dto" value="${requestScope.Re_dto }"/>
		
		<c:choose>
			
			<c:when test="${udto.user_phone == ''}">
				예약, 결제를 하실려면 <a onclick="SMSAuth();">휴대폰 인증</a>을 하셔야합니다.
			</c:when>
		</c:choose>>
		
	
	</div>
	
	
</body>
</html>