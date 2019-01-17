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
<script>
	$(function(){
		
		$("#mainTag").css("padding-left","300px");
		
	})

</script>

</head>
<body>

<div id ="mainTag">
<img src="E:/upload/스낵면.png">
<a href="InsertHotelForm.hotel">호텔등록</a>
	<h2>호텔메인</h2>
</div>	
<c:set var="list" value="${requestScope.list }"></c:set>

<c:choose>
	<c:when test="${list == null }">
		<h2>아직 등록된 호텔이 없습니다. 호텔을 등록해주세요↓↓↓</h2>
		<a href="../InsertHotelForm.hotel">호텔등록</a>
	
	</c:when>
	
	<c:otherwise>

 <%-- 
	<%
		ArrayList list = (ArrayList)request.getAttribute("list");
		for(int i=0; i<list.size(); i++){
			HotelDTO dto = (HotelDTO)list.get(i);
			out.print(dto.getH_imgpath());
			out.print(dto.getH_imgname());
		}
	%>
--%>	


		<c:forEach var = "HotelDTO" items="${requestScope.list}">
		<div id="fh5co-main">
			<div class="fh5co-narrow-content">
				<div class="row animate-box" data-animate-effect="fadeInLeft">
					<div class="col-md-3 work-item">
						<a href="work.html">
							<img src="${HotelDTO.h_imgpath}${HotelDTO.h_imgname}" alt="" class="img-responsive">
							<h3 class="fh5co-work-title">이미지</h3> 
							<p>간략설명</p>
						</a>
					</div>
						
				</div>
			</div>
		</div>
	</div>	
		</c:forEach>
	
	</c:otherwise>

</c:choose>	
		
		
	
	
</body>
</html>