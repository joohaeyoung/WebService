<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Weather Forecast</title>

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

<h1 class="sub-header" align="center">서울 날씨 예보</h1>
<div class="table-responsive">
    <table class="table table-striped">
        <tbody>
        <c:forEach var="fcast" items="${fcastmodel}">
            <tr>
                <c:choose>
                    <c:when  test="${fcast.id=='0' or fcast.id=='1'}">
                        <td><B>${fcast.title}</B></td>
                        <td><B>${fcast.fcttext}</B></td>
                        <td><img src="${fcast.icon}"></td>
                    </c:when>
                    <c:otherwise>
                        <td>${fcast.title}</td>
                        <td>${fcast.fcttext}</td>
                        <td><img src="${fcast.icon}">
                     </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</body>
</html>