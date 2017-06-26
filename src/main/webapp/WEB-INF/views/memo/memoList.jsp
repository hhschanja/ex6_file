<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

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
			
			memoView(1);
			
		});
		
		
		
		function memoWrite(writer,contents){
			$.ajax({
				url:"memoWrite",
				type:"POST",
				data:{writer:writer,contents:contents},
				success:function(data){
					$('#result').html(data.trim());
				}
				
			});
		};
		
		
		function getList(curPage, kind, search) { //여기에다가 AJAX코드를 치면
			$.ajax({
				url:"getMemoList",
				type:"GET",
				data:{curPage:curPage,kind:kind,search:search},
				success:function(data){
					
/* 					alert(data);		
					data = data.trim();
					data = JSON.parse(data);  */
				
					var result = "<table>";
					$(data).each(function() { //하나 꺼내서 집어넣어라
						
						result=result+"<tr>";
						result=result+"<td>"+this.num+"</td>";
						result=result+"<td>"+this.contents+"</td>";
						result=result+"<td>"+this.writer+"</td>";
						result=result+"<td>"+this.date+"</td>";
						result=result+"</tr>";
					});
						result=result+"</table>";
						$('#result').html(result);
				}
			});
			
		}
		
		function memoView() {
			
			$.get("memoView/num="+num,function(data){
				alert(data.writer);
			})
			
		}
		
		
		
		
		
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
<input type="button" id="btnView">

</body>
</html>








