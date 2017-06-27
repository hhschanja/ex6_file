<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/memo.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
 
	$(function() { //페이지가 뿌려진 다음에  getList함수를 실행
		getList(1,'','');
		

		$("#btn").click(function() {
				
			var writer = $("#writer").val();
			var contents = $("#contents").val();
			
			memoWrite(writer,contents);
			
		});
	
		$("#btnView").click(function(){
			
			memoView(999);
			
		});
		
	});	
	
	
	
	
		
			//ajax들~
			/* $.get("URL?neme=value",function(data){});
			$.post("URL",{name:value},function(data){});
			$.ajax({
				url:value,
				datatype:,
				data:{},
				success:function(data){
					
				}
				
			});
			
			$("result").load //받아온 옴을 result에 뿌려주세요
			 */

	
	
	
	
</script>
</head>
<body>
<div id="result">
</div>
<form action="" method="post">
<p><input type="text" id="writer"></p>
<textarea rows="" cols="" id="contents"></textarea>
<input type="button" id="btn" value="버튼">
</form>
<input type="button" id="btnView" value="VIEW999">

</body>
</html>








