<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>차량렌트</h2>
	<form action="">
		<table>
			<tr>
				<td>
				차량명 :
				대여금액 :
				</td>
			</tr>
			<tr>
				<td>
				차량검색
				<select name="car_category">
					<option value="small">소형</option>
					<option value="middle">중형</option>
					<option value="big">대형</option>
				</select>
				<input type="submit" value="차량검색">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>