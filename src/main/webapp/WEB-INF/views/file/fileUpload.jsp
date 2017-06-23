<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<h1>단일 파일 업로드</h1>
<form action="./fileUpload" method="post" enctype="multipart/form-data" > 
	<input type="text" name="name">
	<input type="file" name="f1">
	<button>버튼</button>
</form>
<hr>

<h1>다중 파일 업로드 여러개의 파라미터 이름이 다를때 몇개인지 알고</h1>
<form action="./multiFileUpload" method="post" enctype="multipart/form-data" > 
	<input type="text" name="name">
	<input type="file" name="f1">
	<input type="file" name="f2">
	<button>버튼</button>
</form>

<hr>

<h1>다중 파일 업로드 파라미터 이름이 같을때 몇개인지 알고</h1>
<form action="./sameMultiFileUpload" method="post" enctype="multipart/form-data" >
	<input type="text" name="name">
	<input type="file" name="f1">
	<input type="file" name="f1">
	<button>버튼</button>
</form>

<hr>

<h1>다중 파일 업로드 파라미터 이름도 모르고 몇개인지도 모를때</h1>
<form action="./upload" method="post" enctype="multipart/form-data" >
	<input type="text" name="name">
	<input type="button" id="add" value="FileADD">
	<div id="fff">
	
	</div>
	
	<button>시발</button>
</form>

</body>
<script type="text/javascript">


	var count = 1;

	$('#add').click(function() {
		
		if(count<=5){ 
			
			$('#file').append('<p><input type="file" name="f'+count+'"><span class="del">X</span></p>');
		
			count++;
		}else{
			alert("5개만 가능");
		}
		
	});
	
	$('#fff').on("click",".del",function() { //parent() 선택된 애의 한단계 위에 놈을 지정해줄 때
		
		$(this).parent().remove();
		
		count--;
	})
	
	
</script>

</html>