<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" method="post">
			<table width="1000" border="0" align="center">
				<tr align="center">
					<td rowspan="7" width="600">
						<!-- <img  src="img/${param.carimg}" width="500"> 차 이미지 -->
					</td>
					<td align="center" width="200">대여기간</td>
					<td align="center" width="200">
						<select name="carreserveday">
							<option value="1">1일</option>
							<option value="2">2일</option>
							<option value="3">3일</option>
							<option value="4">4일</option>
							<option value="5">5일</option>
						</select>
					</td>					
				</tr>
				<tr>
					<td align="center">대여일</td>
					<td align="center"><input type="date" name="carbegindate"></td>
				</tr>
				<tr>
					<td align="center">보험적용</td>
					<td align="center">
						<select name="carins">
							<option value="1">보험적용(1일1만원)</option>
							<option value="0">미적용</option>
						</select>
					</td>			
				</tr>
				<tr>
					<td align="center">무선WIFI</td>
					<td align="center">
						<select name="carwifi">
							<option value="1">적용(1일1만원)</option>
							<option value="0">미적용</option>
						</select>
					</td>			
				</tr>				
				<tr>
					<td align="center">네비게이션</td>
					<td align="center">
						<select name="carnave">
							<option value="1">적용(무료)</option>
							<option value="0">미적용</option>
						</select>
					</td>			
				</tr>
				<tr>
					<td align="center">베이비시트</td>
					<td align="center">
						<select name="carbabyseat">
							<option value="1">적용(1일1만원)</option>
							<option value="0">미적용</option>
						</select>
					</td>			
				</tr>
				<tr>
					<td align="center">
						<input type="button" value="차량목록보기" onclick="location.href='T_CarRent.jsp'">
					</td>
					<td align="center">
						<input type="submit" value="예약하기">
					</td>
				</tr>							
			</table>
		</form>
</body>
</html>