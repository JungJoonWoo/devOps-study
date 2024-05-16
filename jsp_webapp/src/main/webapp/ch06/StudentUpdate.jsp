<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> 수정 </title>
</head>
<body>
<h2>수정</h2>
<%
    String id = request.getParameter("id");
%>

<form action="/studentControl?action=updatePost" method="post">
    <input type="hidden" name="id" value="<%=id%>" />
    이메일<input type="text" name="email" /><br>
    <button type="submit">수정</button>
</form>
</body>
</html>
