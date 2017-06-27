<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="">
<p>1. 납품자명: <input type="text" placeholder="name"></p>
<p>2. email: <input type="email" placeholder="answs@naver.com"></p>
<p>3. 홈페이지: <input type="url" placeholder="http://"></p>

<ul>
<li> 상품명: 
<select>
<option role="dsdsdsd">dog1004</option>
<option>catchicken</option>
<option>milk</option>
</select>
</li>
<li> 납품수량: <input type="number"  min="10" max="100" step="10" placeholder="최소 10 이상"></li>
<li> 납품등급 : <input type="range" min="0" max="10" step="2"></li>
<li> 기타사항: <textarea rows="" cols=""></textarea></li>

</ul>

<button>send message</button>
</form>

</body>
</html>