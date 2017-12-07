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

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Freelancer - Start Bootstrap Theme</title>



    <!-- Bootstrap core CSS -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- Plugin CSS -->
    <link href="resources/vendor/magnific-popup/magnific-popup.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="resources/css/freelancer.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/dashboard.css" rel="stylesheet">

</head>
<body>

<c:set var="user" value="${SPRING_SECURITY_CONTEXT.authentication.principal}"/>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg bg-secondary fixed-top text-uppercase" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="/">DKE 여행</a>
        <c:choose>
            <c:when test="${user==null}">
                <form action="j_spring_security_check" method="post" >
                    <input type="text" placeholder="email" name="j_username"/>
                    <input type="password" placeholder="password" name="j_password"/>
                    <input type="submit" value="Signin"/>
                </form>
            </c:when>
            <c:otherwise>
                ${user.name}님 환영합니다.<a href="/user/signout">  &nbsp;&nbsp;로그아웃</a><br/>
            </c:otherwise>
        </c:choose>


        <button class="navbar-toggler navbar-toggler-right text-uppercase bg-primary text-white rounded" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fa fa-bars"></i>
        </button>

    </div>
</nav>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<h1 class="sub-header" align="center">서울 문화 행사 목록</h1>
    <div class="table-responsive">

        <table class="table table-striped">
            <thead>
            <tr>
                <th>제목</th>
                <th>시작 일</th>
                <th>마지막 일</th>
                <th>장소</th>
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

    </div>



</body>
</html>
