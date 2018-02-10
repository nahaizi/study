<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="saysth.do" method="post">
		<table>
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="2"><input type="submit" value="Save" /></td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td><input name="users[0].firstName" value="aaa" /></td>
					<td><input name="users[0].lastName" value="bbb" /></td>
				</tr>
				<tr>
					<td><input name="users[1].firstName" value="ccc" /></td>
					<td><input name="users[1].lastName" value="ddd" /></td>
				</tr>
				<tr>
					<td><input name="users[2].firstName" value="eee" /></td>
					<td><input name="users[2].lastName" value="fff" /></td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>