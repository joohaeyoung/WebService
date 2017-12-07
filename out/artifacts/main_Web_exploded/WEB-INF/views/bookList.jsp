<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book list</title>
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
        <td>ID</td>
        <td>Title</td>
        <td>author</td>
        <td>page</td>
        <td>Userid</td>
        <td></td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.page}</td>
            <td>${book.userid}</td>
            <td>
                <a href="/book/delete?userid=${book.userid}&bookid=${book.id}">삭제</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
