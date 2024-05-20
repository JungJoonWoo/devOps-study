<%--
  Created by IntelliJ IDEA.
  User: happy
  Date: 2024-05-17
  Time: 오후 2:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType = "text/html;charset=UTF-8" language = "java" %>
<%@ page contentType = "text/html;charset=UTF-8" language = "java" isELIgnored = "false" %>

<html>
<head>
    <title>
        News Detail
    </title>
</head>
<body>
<header>
    <h1>${news.title}</h1>
    <hr>

</header>
<%--    <img src = "${news.img}" alt = "${news.img}" crossorigin="anonymous" width = "300" height = "300">--%>
    <img src="/img/test.jpg" alt="test.jpg" crossorigin="anonymous" width="300" height="300">
<main>
    <div>
        Date: ${news.date}
    </div>
    <div>
        ${news.content}
    </div>
</main>
</body>
</html>
