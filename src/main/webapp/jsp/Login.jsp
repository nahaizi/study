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
		<button id="login" onclick="">确定</button>
	</div>
	<div>
		<button id="find" onclick="">检索</button>
	</div>
	<div>
		<button id="test3" onclick="">ModelAndView</button>
	</div>
	<div>
	<label value="${res}">
	
	</label>
	</div>
	<div><h2>${res}</h2></div>
	
	<div>
		<button id="logintest" onclick="logintest()">logintest</button>
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
/* 	function login() {
		alert("555");
	} */

	function logintest(){
	    window.location.href = 'jsp/logintest.jsp';
	}
	
	$(function() {
		$("#login").click(function() {
			var data={"username": "henry", "password": "880058"};
			console.log(JSON.stringify(data));
			$.ajax({
// 				url : "login/login1.do",
// 				url : "login/test.do",
				url : "login/login.do",
				type : "POST",
				dataType: "json", 
			    contentType: "application/json; charset=UTF-8",
				data : JSON.stringify(data),
				success : function(res) {
					 window.location.href = "jsp/logintest.jsp";  
// 					console.log(res);
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
		
	
		$("#find").click(function() {
			var data={"userName": "henry", "password": "880058"};
			console.log(JSON.stringify(data));
			$.ajax({
				url : "login/find.do",
				type : "POST",
				data :/*  {
					username : $("#name").val(),
					password : $("#password").val()
				} */
				JSON.stringify(data)
				,
				success : function(res) {
// 					alert(res);
				},
				error : function(err) {
					console.log(err);
				}
			})
		})
		
		$("#test3").click(function() {
			$.ajax({
				url : "login/test3.do",
				type : "POST",
				data : {
					username : $("#name").val(),
					password : $("#password").val()
				},
				success : function(res) {
// 					alert(res);
				},
				error : function(err) {
					console.log(err);
				}
			})
		})
		
	});
</script>
</html>