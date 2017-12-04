<%--
  Created by IntelliJ IDEA.
  User: haeyoungJoo
  Date: 2017-12-04
  Time: 오후 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>concertList</title>

    <style>
        table, tr, td {
            border: 1px solid black;
            text-align:center;
        }
    </style>

</head>
<body>

<table>
    <thead>
    <tr>
        <td>제목</td>
        <td>시작 일</td>
        <td>마지막 일</td>
        <td>장소</td>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="c" items="${concert}">
        <tr>
            <td>${c.title}</td>
            <td>${c.startdate}</td>
            <td>${c.enddate}</td>
            <td>${c.place}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>

</body>
</html>
