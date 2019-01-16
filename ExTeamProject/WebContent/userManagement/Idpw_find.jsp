<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>비밀번호 찾기</title>
<link href="../css/can.css" rel="stylesheet" type="text/css" /><!-- css파일연결 -->
</head>

<script>
	
	//password 찿기
	function pw_search() {
		var f = document.pw_f;
		if (f.mem_name.value == "") {
			alert("닉네임를 입력해주세요.");
			f.mem_name.focus();
			return;
		}
		if (f.mem_email.value == "") {
			alert("E-mail을 입력해주세요.");
			f.mem_email.focus();
			return;
		}
		f.submit();
	}
</script>


<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td bgcolor="#999999"  style="padding:5px 10px;" class="white12bold">비밀번호 찾기</td>
	</tr>
</table>
<table width="450" border="0" cellspacing="0" cellpadding="0" class="grey12">
	<tr>
		<td style="padding:20px 0 0 0">
			<table width="420" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td style="padding:15px; border-top:2px #cccccc solid; border-right:2px #cccccc solid; border-bottom:2px #cccccc solid; border-left:2px #cccccc solid;">
						<form name="id_f" id="id_f" method="post" action="IdPw_pro.jsp">					
					  </form>
						<form name="pw_f" id="pw_f" method="post" action="IdPw_pro2.jsp">
  						<table width="380" border="0" cellspacing="0" cellpadding="0">
  						  <tr>
  								<td class="stitle">비밀번호 찾기</td>
  							</tr>
  						</table>
  						<table width="380" border="0" cellspacing="1" class="regtable">
  							<tr>
  								<td width="100" height="25" bgcolor="#f4f4f4">닉네임</td>
  								<td width="130">
  									<input type="text" name="mem_name" id="mem_name" tabindex="5"/>
  								</td>
  								<td rowspan="2" align="center"><div class="bts"><a href="javascript:pw_search();"  tabindex="8"><span style="width:80px">비밀번호 찾기</span></a></div></td>
  							</tr>
  							<tr>
  								<td height="25" bgcolor="#f4f4f4">e-Mail</td>
  								<td>
  									<input type="text" name="mem_email" id="mem_email" tabindex="6"/>
  								</td>
  							</tr>
  						</table>
            </form>
            
            
            
					</td>
				</tr>
			</table>
			<table border="0" align="right" cellpadding="0" cellspacing="0">
				<tr>
					<td height="40" style="padding:0 13px 0 0">
						<div class="bts"><a href="javascript:self.close();"><span style="width:50px">닫기</span></a></div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>
