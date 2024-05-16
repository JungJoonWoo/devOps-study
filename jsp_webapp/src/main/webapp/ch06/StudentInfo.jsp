<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<html>
<head>
    <title> 학생 정보 </title>
</head>
<body>
<table border = "1">
    <tr>
        <th>번호</th>
        <th>이름</th>
        <th>대학</th>
        <th>생일</th>
        <th>이메일</th>
    </tr>
    <c:forEach var = "student" items = "${students}">
        <tr onclick="clickRow('${student.id}')">
            <td> ${student.id} </td>
            <td> ${student.username} </td>
            <td> ${student.univ} </td>
            <td> ${student.birth} </td>
            <td> ${student.email} </td>
        </tr>
    </c:forEach>

    <hr>

</table>
<form action = "/studentControl?action=insert" method = "post">
    <label>
        이름 <input type = "text" name = "username"><br>
        대학 <input type = "text" name = "univ"><br>
        생일 <input type = "date" name = "birth"><br>
        이메일 <input type = "text" name = "email"><br>
        <button type = "submit">등록</button>
    </label>
</form>
<script>
  function clickRow(id) {
    // location.href = "/ch06/StudentUpdate.jsp?id=" + id;
    location.href = "/studentControl?action=updateGet&id=" + id;
  }

</script>
</body>
</html>
