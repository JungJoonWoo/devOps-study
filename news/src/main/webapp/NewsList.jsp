<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<table>
    <tr>
        <th>News ID</th>
        <th>News Title</th>
        <th>News Date</th>
    </tr>
    <c:forEach var="newsItem" items="${news}" >
        <tr onclick="showNewsDetail(${newsItem.aid})">
            <td>${newsItem.aid}</td>
            <td>${newsItem.title}</td>
            <td>${newsItem.date}</td>
        </tr>
    </c:forEach>

</table>
<form action="/news.nhn?action=addNews" method="post" enctype="multipart/form-data">
    제목 <input type="text" name = "title" />
    <br/>
    이미지 <input type="file" name = "img" />
    <br/>

    <textarea name="content" cols="40" rows="40" placeholder="내용"></textarea>
    <br />
    <button type="submit" name="action" value="add">뉴스 등록</button>
</form>
<script>
  function showNewsDetail(aid) {
    location.href = "/news.nhn?action=showNewsDetail&aid=" + aid;
  }
</script>
