<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>맛집 메인</title>

</head>
<body>
	<c:if test="${session.user_email != null}">
		<c:set var="user_email" property="${session.user_email}" />
		<c:set var="list" property="${requestScope.list}" />
	</c:if>
	<c:choose>
		<c:when test="${list == null}">
			<div class="container">
				등록된 맛집 정보가 없습니다. <br/>
				지금 바로 <a href="./insertFoodPage.fo">등록</a>하러 가기.
			</div>
		</c:when>
		<c:otherwise>
			<div align="center">
				<h3>맛집 메인 페이지</h3>
				<p>
					<a href="./insertFoodPage.fo">맛집등록</a>
				</p>
				<c:forEach var="FoodDTO" items="${list}" step="1">
					<div id="fh5co-main">
						<div class="fh5co-narrow-content">
							<div class="row animate-box" data-animate-effect="fadeInLeft">
							<a href="#">
								<img class="img-responsive" src="/${FoodDTO.f_imgpath}${FoodDTO.f_imgname}">
							</a>
								<h3 class="fh5co-work-title">${FoodDTO.f_name}</h3>
								<h4>${FoodDTO.f_content}</h4>
								<p>추천수: ${FoodDTO.f_bestcount}</p>
							
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</c:otherwise>
	</c:choose>

</body>
</html>