<%@page import="dto.UserManagementDTO"%>
<%@page import="hotel.dto.HotelDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">




<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>호텔메인</title>

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>


</head>
<body>

	
<c:set var="list" value="${requestScope.list }"></c:set>

<c:choose>
	<c:when test="${list == null }">
		<h2>아직 등록된 호텔이 없습니다. 호텔을 등록해주세요↓↓↓</h2>
		<a href="../InsertHotelForm.hotel">호텔등록</a>
	
	</c:when>
	
	<c:otherwise>



<%-- 마지막에 최근등록순, 별점높은순, 댓글갯수 많은순 등등으로 설정--%>
		<div id="fh5co-main">
		<div id ="mainTag">
	<a href="InsertHotelForm.hotel">호텔등록</a>
	<h2>호텔메인</h2>
</div>
			<div class="fh5co-narrow-content">
				<div class="row animate-box" data-animate-effect="fadeInLeft">
		<c:forEach var = "HotelDTO" items="${requestScope.list}" step="1">
		
					<%-- 호텔설명을 간략히 보여줌 --%>
		
					<div class="col-md-3 work-item">
						<a href="HotelDetail.hotel?h_no=${HotelDTO.h_no }" target="_blank">
							<img src="hotel/${HotelDTO.h_imgpath}${HotelDTO.h_imgname}" alt="" class="img-responsive">
							<h3 class="fh5co-work-title">${HotelDTO.h_name } <-호텔 이름부분</h3> 
							<h4>${HotelDTO.h_content } <- 호텔내용부분 30자이상이면 자르게설정해놨음<h4>
							<h4>이방의 평균가격은 [추후설정]</h4>
							<p>추천수 : ${HotelDTO.h_bestcount }</p>
						</a>
					</div>
						
			
		
	
		</c:forEach>
				</div>
			</div>
		</div>	
	</c:otherwise>

</c:choose>	
		
		
	
	
</body>
</html>