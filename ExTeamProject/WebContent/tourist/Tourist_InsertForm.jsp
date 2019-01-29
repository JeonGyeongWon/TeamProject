<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 <body>
 <center>
 <h2>관광지 등록</h2>
 <form action="./InsertTouristForm.tourist" method="post" enctype="multipart/form-data">
 <table>
 	<tr>
 		<td>
    	<hr>
    	부산<input type="radio" name="radio" value="부산">
    	기장군<input type="radio" name="radio" value="기장군">
    	<button type="button" name="button" id="weatherButton">날씨정보</button>
    	<hr>
    	<div id="div">
      		현재기온: <span id="tc"></span> <br>
      		최고기온: <span id="tmax"></span><br>
      		최저기온: <span id="tmin"></span><br>
      		하늘상태: <span id="skyname"></span><br>
      	<div class="weatherIcon">
      	<div class="" id="whatWeather">
      	<div class="inner">
      	</div>
      	</div>
    	</div> <br>

      	풍속: <span id="wspd"></span><br>
      	최근 1시간 강우량: <span id="last1hour"></span><br>
      	최근 24시간 강우량: <span id="last24hour"></span><br>
      	관측소: <span id="stationname"></span><br>
      	관측시간: <span id="timeObservation"></span><br>
    	</div>
    	<hr>
    	</td>
   	</tr>
    <tr>
		<td>관광지 이름</td>
		<td>
			<input type="text" name="t_name" id="t_name" required="required">
		</td>
	</tr>
	<tr>
		<td>관광지 설명</td>
		<td>
			<input type="text" name="t_content" id="t_content">
		</td>
	</tr>
	<tr>
		<td>관광지 이미지</td>
		<td>
			<input type="file" name="t_img">
		</td>
	</tr>
	<tr>
		<td>
			<a onclick="execDaumPostcode();">주소검색(클릭)</a>
		</td>
	</tr>
</table>
</form>
</center>
  </body>
  <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script> <!-- 다음주소찾기 ... -->
  <script type="text/javascript">
  $("#weatherButton").click(function(){
    var lat, lon
    if (document.getElementsByName('radio')[0].checked) {
      lat= 35.17944
      lon= 129.07556
    }
    else if (document.getElementsByName('radio')[1].checked) {
      lat= 35.24306
      lon= 129.21944
    }
    $.ajax({
      url:'https://api2.sktelecom.com/weather/current/minutely?version=1&'
      +"lat="+ lat +"&lon="+ lon,
      headers: {
        appKey: "7ebf183b-84c7-49a1-a65d-ada17a3b2018"
      },
      success:function(data){
        console.log(data);
        var weather = data.weather.minutely["0"]
        $("#tc").html(weather.temperature.tc)
        $("#tmax").html(weather.temperature.tmax)
        $("#tmin").html(weather.temperature.tmin)
        $("#skyname").html(weather.sky.name)

        $("#wspd").html(weather.wind.wspd)
        $("#last1hour").html(weather.rain.last1hour)
        $("#last24hour").html(weather.rain.last24hour)
        $("#stationname").html(weather.station.name)
        $("#timeObservation").html(weather.timeObservation)
        console.log(weather.sky.code);
        var weatherClass=""
        if (weather.sky.code=="SKY_A01") {
          weatherClass="sunny"
        }
        else if (weather.sky.code=="SKY_A02") {
          weatherClass="mostlysunny"
        }
        else if (weather.sky.code=="SKY_A03") {
          weatherClass="mostlycloudy"
        }
        else if (weather.sky.code=="SKY_A04") {
          weatherClass="chancerain"
        }
        else if (weather.sky.code=="SKY_A05") {
          weatherClass="snow"
        }
        else if (weather.sky.code=="SKY_A06") {
          weatherClass="chancesleet"
        }

        else if (weather.sky.code=="SKY_A07") {
          weatherClass="cloudy"
        }

        $("#whatWeather").attr('class', weatherClass);
        console.log(weatherClass);
      }
    })

    })
    
    <%--팝업창을 이용한 찾기를 가져옴--%>

$(function(){
	$("#room input[type=file]").on("change",function(){
		
		
		
		$("#subimg").html("서브이미지 선택!! 최대5개 ");
		
		for(var i=2; i<7; i++ ){
		var file = "<input type='file' name='h_img"+i+"'>";
		$("#subimg").append(file);
		}
		
	});
	
})

function execDaumPostcode() {
    	new daum.Postcode({ 
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
                
                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("roadAddress").value = roadAddr;
                document.getElementById("jibunAddress").value = data.jibunAddress;
                
            }
        }).open();
    }
  </script>
<style media="screen">
.container {
margin: 12% auto;
text-align: center;
width: 80%;
}
.weatherIcon {
display: inline-block;
font-family: Helvetica, sans-serif;
/* Redefine this font size if resizing height & width */
font-size: 1em;
height: 100px;
line-height: 1em;
margin: 2%;
position: relative;
width: 100px;
}
.weatherIcon:before, .weatherIcon:after {
content: "";
height: inherit;
left: 0;
top: 0;
width: inherit;
}
.weatherIcon > div:before, .weatherIcon > div:after,
.weatherIcon .inner:before, .weatherIcon .inner:after {
content: "";
letter-spacing: 0;
position: absolute;
}
.clear, .sunny, .mostlysunny, .partlycloudy, .mostlycloudy, .partlysunny, .cloudy, .fog, .hazy, .chancerain, .rain, .chancetstorms, .tstorms, .chancesleet, .sleet, .chanceflurries, .flurries, .chancesnow, .snow, .inner {
height: inherit;
width: inherit;
}

/*** Clear/Sunny ***/
.clear, .sunny {
margin-top: 48.5%;
}
.clear, .clear:before, .clear > .inner:before, .clear > .inner:after, .sunny, .sunny:before, .sunny > .inner:before, .sunny > .inner:after {
background: #FFD632;
left: 0;
top: 48.5%;
width: 100%;
height: 0.2em;
}
.clear:before, .sunny:before {
transform: rotate(45deg);
}
.clear > .inner:before, .sunny > .inner:before {
transform: rotate(90deg);
}
.clear > .inner:after, .sunny > .inner:after {
transform: rotate(135deg);
}
.clear:after, .sunny:after {
background: #FFD632;
border-radius: 50%;
height: 60%;
left: 20%;
top: 20%;
width: 60%;
}

/*** Partly Cloudy/Mostly Sunny ***/
.mostlysunny, .partlycloudy {
background: #FFD632;
height: 80%;
margin-left: 48.5%;
top: 0;
width: 0.2em;
}
.mostlysunny:before, .partlycloudy:before {
background: #FFD632;
left: 0;
top: 48.5%;
width: 100%;
height: 0.2em;
}
.mostlysunny > .inner:before, .partlycloudy > .inner:before {
border-bottom: 0.2em solid #FFD632;
border-left: 0.2em solid #FFD632;
height: 80%;
left: 8%;
top: -48.5%;
transform: rotate(-45deg);
width: 80%;
}
.mostlysunny > .inner, .partlycloudy > .inner {
background: #FFD632;
border-radius: 50%;
height: 60%;
left: 20%;
position: absolute;
top: 20%;
width: 60%;
}
.mostlysunny > .inner:after, .partlycloudy > .inner:after {
background: #fff;
border-radius: 50%;
bottom: -33%;
height: 65%;
right: -15%;
width: 70%;
}
.mostlysunny:after, .partlycloudy:after {
background: #fff;
border-radius: 50%;
bottom: 0;
height: 50%;
left: 10%;
width: 55%;
}
/*** Mostly Cloudy/Partly Sunny ***/
.mostlycloudy,
.partlysunny {
background: #FFD632;
height: 80%;
margin-left: 48.5%;
top: 0;
width: 0.2em;
}
.mostlycloudy:before, .partlysunny:before {
background: #FFD632;
left: 0;
top: 48.5%;
width: 100%;
height: 0.2em;
}
.mostlycloudy > .inner:before, .partlysunny > .inner:before {
border-bottom: 0.2em solid #FFD632;
border-left: 0.2em solid #FFD632;
height: 80%;
left: 8%;
top: -48.5%;
transform: rotate(-45deg);
width: 80%;
}
.mostlycloudy > .inner, .partlysunny > .inner {
background: #FFD632;
border-radius: 50%;
height: 60%;
left: 20%;
position: absolute;
top: 20%;
width: 60%;
}
.mostlycloudy > .inner:after, .partlysunny > .inner:after {
background: #fff;
border-radius: 50%;
bottom: -33%;
height: 82%;
right: -34%;
width: 90%;
}
.mostlycloudy:after, .partlysunny:after {
background: #fff;
border-radius: 50%;
bottom: 0%;
height: 63%;
left: 0;
width: 70%;
}
/*** Cloudy ***/
.cloudy:before, .cloudy > .inner:before, .cloudy > .inner:after, .cloudy:after {
background: #fff;
border-radius: 50%;
}
.cloudy:before {
height: 35%;
right: 0;
top: 0;
width: 38%;
}
.cloudy > .inner:before {
height: 27%;
left: 45%;
top: 8%;
width: 30%;
}
.cloudy > .inner:after {
bottom: 0;
height: 50%;
right: 0;
width: 55%;
}
.cloudy:after {
bottom: 0;
height: 63%;
left: 0;
width: 70%;
}
/*** Fog / Hazy ***/
.fog:before, .fog:after, .hazy:before, .hazy:after {
background: #fff;
border-radius: 50%;
}
.fog:before, .hazy:before {
height: 63%;
left: 0;
top: 0;
width: 70%;
}
.fog:after, .hazy:after {
height: 50%;
right: 0;
top: 13%;
width: 55%;
}
.fog > .inner:before, .fog > .inner:after, .hazy > .inner:before, .hazy > .inner:after {
color: #fff;
content: "\2307";
font-size: 5em;
left: 7%;
transform: rotate(90deg);
}
.fog > .inner:before, .hazy > .inner:before {
bottom: 14%;
}
.fog > .inner:after, .hazy > .inner:after {
bottom: 0;
}

/*** Chance Rain / Rain ***/
.chancerain:before, .chancerain > .inner:before, .rain:before, .rain > .inner:before {
border-left: 0.2em dashed #fff;
border-right: 0.2em dashed #fff;
bottom: 0;
height: 60%;
transform: skew(-20deg);
width: 13%;
}
.chancerain:before, .rain:before {
left: 25%;
}
.chancerain > .inner:before, .rain > .inner:before {
left: 57%;
}
.chancerain > .inner:after, .chancerain:after, .rain > .inner:after, .rain:after {
background: #7799AF;
border-radius: 50%;
}
.chancerain > .inner:after, .rain > .inner:after {
height: 63%;
left: 0;
top: 0;
width: 70%;
}
.chancerain:after, .rain:after {
height: 50%;
right: 0;
top: 13%;
width: 55%;
}

/*** Chance T-Storms / T-Storms ***/
.chancetstorms:before, .tstorms:before {
background: #FFD632;
height: 30%;
left: 43%;
top: 50%;
transform: skew(-20deg);
width: 10%;
}
.chancetstorms > .inner:before, .tstorms > .inner:before {
border-right: 0.7em solid transparent;
border-top: 1.9em solid #FFD632;
bottom: 0;
left: 45%;
transform: skew(-20deg);
}
.chancetstorms > .inner:after, .chancetstorms:after,
.tstorms > .inner:after, .tstorms:after {
background: #7799AF;
border-radius: 50%;
}
.chancetstorms > .inner:after, .tstorms > .inner:after {
height: 63%;
left: 0;
top: 0;
width: 70%;
}
.chancetstorms:after, .tstorms:after {
height: 50%;
right: 0;
top: 13%;
width: 55%;
}
/*** Chance Sleet / Sleet ***/
.chancesleet:before, .sleet:before {
border-left: 0.2em dashed #fff;
border-right: 0.2em dashed #fff;
bottom: 0;
height: 60%;
left: 30%;
transform: skew(-20deg);
width: 35%;
}
.chancesleet > .inner:before, .sleet > .inner:before {
bottom: 12%;
color: #fff;
content: "\2733\ \ \2733";
font-size: 1em;
left: 27%;
transform: rotate(-70deg);
width: 40%;
}
.chancesleet > .inner:after, .chancesleet:after, .sleet > .inner:after, .sleet:after {
background: #BACEDD;
border-radius: 50%;
}
.chancesleet > .inner:after, .sleet > .inner:after {
height: 63%;
left: 0;
top: 0;
width: 70%;
}
.chancesleet:after, .sleet:after {
height: 50%;
right: 0;
top: 13%;
width: 55%;
}
/*** Chance Flurries / Flurries ***/
.chanceflurries > .inner:before, .chanceflurries > .inner:after, .flurries > .inner:before, .flurries > .inner:after {
color: #fff;
content: "\25CF\ \25CF\ \25CF";
font-size: 1.1em;
}
.chanceflurries > .inner:before, .flurries > .inner:before {
bottom: 17%;
right: 25%;
}
.chanceflurries > .inner:after, .flurries > .inner:after {
bottom: 0;
left: 25%;
}
.chanceflurries:before, .chanceflurries:after,
.flurries:before, .flurries:after {
background: #BACEDD;
border-radius: 50%;
}
.chanceflurries:before, .flurries:before {
height: 63%;
left: 0;
top: 0;
width: 70%;
}
.chanceflurries:after, .flurries:after {
height: 50%;
right: 0;
top: 13%;
width: 55%;
}
/*** Chance Snow / Snow ***/
.chancesnow > .inner:before, .chancesnow > .inner:after, .snow > .inner:before, .snow > .inner:after {
color: #fff;
content: "\2733\ \2733\ \2733";
font-size: 1em;
}
.chancesnow > .inner:before, .snow > .inner:before {
bottom: 17%;
right: 21%;
}
.chancesnow > .inner:after, .snow > .inner:after {
bottom: 0;
left: 21%;
}
.chancesnow:before, .chancesnow:after,
.snow:before, .snow:after {
background: #BACEDD;
border-radius: 50%;
}
.chancesnow:before, .snow:before {
height: 63%;
left: 0;
top: 0;
width: 70%;
}
.chancesnow:after, .snow:after {
height: 50%;
right: 0;
top: 13%;
width: 55%;
}
</style>

</body>
</html>