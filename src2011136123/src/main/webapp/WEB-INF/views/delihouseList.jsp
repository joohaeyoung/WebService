<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>DeliList</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

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
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item mx-0 mx-lg-1">
                    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#portfolio">Portfolio</a>
                </li>
                <li class="nav-item mx-0 mx-lg-1">
                    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#about">About</a>
                </li>
                <li class="nav-item mx-0 mx-lg-1">
                    <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#contact">Contact</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<td>
    <a href="/">뒤로가기</a><br/>
</td>

<h1 class="sub-header" align="center">서울시 맛집-호텔-랜드마크 리스트</h1>
<div class="table-responsive">
    <table class="table table-striped">
        <thead>
        <tr>
            <td>카테고리</td>
            <td>상호</td>
            <td>구</td>
            <td>동</td>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="d" items="${deli}">
            <tr>
                <td>${d.cate2name}</td>
                <td>${d.namekor}</td>
                <td>${d.hkorgu}}</td>
                <td>${d.hkordong}</td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</body>
</html>
