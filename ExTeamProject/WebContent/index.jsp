<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>부산 정보 모아보기</title>

<!-- Animate.css -->


<!-- Modernizr JS -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=906e68dba1adb50425e650ad46575c5b&libraries=services"></script>
</head>


<body>
	<c:set var="center" value="${param.center}" />

	<c:out value="${center}" />

	<c:if test="${center == null}">
		<c:set var="center" value="Main.jsp" />
	</c:if>

	<jsp:include page="header.jsp" />
	<jsp:include page="sidevar.jsp" />
	<jsp:include page="${center}" />
	<jsp:include page="footer.jsp" />




	<%-- 토글 버튼을 위한 링크 --%>
	<!-- MAIN JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
	<script
		src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>

</body>


</html>