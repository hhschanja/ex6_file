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
<form action="fileUpload" method="post" enctype="multipart/form-data" >
	<input type="text" name="name">
	<input type="file" name="f1">
	<button>시발</button>
</form>
<hr>

<form action="./multiFileUpload" method="post" enctype="multipart/form-data" >
	<input type="text" name="name">
	<input type="file" name="f1">
	<input type="file" name="f2">
	<button>시발</button>
</form>

<hr>
<!-- 파라미터 이름이 같은 경우 -->
<form action="./sameMultiFileUpload" method="post" enctype="multipart/form-data" >
	<input type="text" name="name">
	<input type="file" name="f1">
	<input type="file" name="f1">
	<button>시발</button>
</form>

<hr>

<form action="./upload" method="post" enctype="multipart/form-data" >
	<input type="text" name="name">
	<input type="button" id="add" value="FileADD">
	<div id="file">
	
	</div>
	
	<button>시발</button>
</form>

</body>
<script type="text/javascript">


	var count = 1;

	$('#add').click(function() {
		
		if(count<=5){
			
			$('#file').append('<p><input type="file" name="f1"><span class="dd">X</span></p>');
		
			count++;
		}else{
			alert("5개만 가능");
		}
		
	});
	
	$('#file').on("click",".dd",function() {
		$(this).remove();
	})
	
	
</script>

</html>