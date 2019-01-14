<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href="https://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css" rel="stylesheet">
<style>
form{
width: 70%;
margin:100px auto;
}
</style>
<script type="text/javascript">
   $(document).ready(function(){
         var   minDate = new Date();
      $("#depart").datepicker({
         showAnim: 'drop',
         numberOfMonth: 1,
         minDate: minDate,
         maxDate: '22/01/2019',
         dateFormat:'dd/mm/yy',
         onClose:function(selectedDate){
            $('#return').datepicker("option","minDate",selectedDate);
         }
      });
      
      $("#return").datepicker({
         showAnim: 'drop',
         numberOfMonth: 1,
         minDate: minDate,
         dateFormat:'dd/mm/yy',
         onClose:function(selectedDate){
            $('#depart').datepicker("option","maxDate",selectedDate);
         }
      });
   });


</script>


</head>
<body>

<form action="" method="post">
<input type="text" id="origin" placeholder="Origin">
<input type="text" id="destination" placeholder="destination">
<input type="text" id="depart" placeholder="depart date">
<input type="text" id="return" placeholder="return date">
<select id="seat">
   <option>Seat</option>
   <option value="1">Seat 1</option>
   <option value="2">Seat 2</option>
   <option value="3">Seat 3</option>
   <option value="4">Seat 4</option>

</select>
<input type="submit" value="Search">

</form>



</body>
</html>