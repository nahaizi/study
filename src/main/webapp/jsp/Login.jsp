<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<script src="<%=basePath%>js/jquery/jquery.js"></script>
<script src="<%=basePath%>js/jquery/jquery.min.js"></script>
<script src="<%=basePath%>js/bootstrap/bootstrap.min.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 浏览器基本配置 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- IE兼容配置 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<title>李君愚的</title>
</head>
<body>
	<h2>Hello World! lijunyu!</h2>
	<div>
		<label>登录名</label><br> <input id="name"></input>
	</div>
	<div>
		<label>密码</label> <br> <input id="password" name="password"></input>
	</div>
	<div>
		<button id="login" onclick="login()">确定</button>
	</div>
</body>

<script type="text/javascript">
	window.onload = function() {
		var userName = "xiaoming";
		// 		alert(userName);
		test();
		$("name").val("lijunyu");
		$("password").val("lijunyu");
	}
	function test() {
		document.getElementById("name").onmouseover = function() {
			$("#name").val("lijunyu");
			// 			document.getElementById("name").value="lijunyu"
		};
// 		document.getElementById("password").onmouseout = function() {
// 			document.getElementById("password").style.backgroundColor = "blue"
// 		};
	}
	function login() {
		alert("555");
	}

	$(function() {
		$("#login").click(function() {
			$.ajax({
				url : "login/find.do",
				type : "POST",
				data : {
					username : $("#name").val(),
					password : $("#password").val()
				},
				success : function(res) {
					alert(res);
				},
				error : function(err) {
					console.log(err);
				}
			})
// 			$.ajax({
// 							var name = $("#username").val();
// 				var age = 18;
// 				var user = {"username":name,"age":age};
// 				$.ajax({
// 				url : 'hello.json',
// 				type : 'POST',
// 				data : JSON.stringify(user), // Request body 
// 				contentType : 'application/json; charset=utf-8',
// 				dataType : 'json',
// 				success : function(response) {
// 				//请求成功
// 				alert("你好" + response.username + "[" + response.age + "]，当前时间是：" + response.time + "，欢迎访问：http://www.zifangsky.cn");
// 				},
// 				error : function(msg) {
// 				alert(msg);
// 				})
		})
	});
</script>
</html>