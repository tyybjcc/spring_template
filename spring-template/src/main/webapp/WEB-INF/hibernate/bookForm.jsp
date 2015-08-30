<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>添加图书</title>
</head>
<body>
<h3>添加图书</h3>
<s:form action="addBook">
	<s:textfield name="book.name" label="书名"/>
	<s:textfield name="book.price" label="价格"/>
	<s:textfield name="book.author" label="作者"/>
	<tr align="center">
		<td colspan="2">
		<s:submit value="添加" theme="simple"/>
		<s:reset value="重设" theme="simple"/>
		</td>
	</tr>
</s:form>
</body>
</html>
