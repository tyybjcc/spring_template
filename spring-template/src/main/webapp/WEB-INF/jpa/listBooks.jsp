<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>全部图书</title>
</head>
<body>
<h3>全部图书</h3>
<table width="640" border="1">
	<s:iterator value="books" var="b">
		<tr>
			<td><s:property value="name"/></td>
			<td><s:property value="price"/></td>
			<td><s:property value="author"/></td>
			<td><a href="${pageContext.request.contextPath}/deleteBook?id=${b.id}">删除</a></td>
		</tr>
	</s:iterator>
</table>
<script>
</script>
</body>
</html>
