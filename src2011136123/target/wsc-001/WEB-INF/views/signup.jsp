<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Signup</title>

  <!-- 부가적인 테마 -->
  <link rel="stylesheet" href="/resources/css/bootstrap.min.css">

  <style>
    body { margin-left: 0px; margin-top: 0px; margin-right: 0px; margin-bottom: 0px; }
    #center { position:absolute; top:50%; left:50%; width:300px; height:200px; overflow:hidden; background-color:#FC0; margin-top:-150px; margin-left:-100px;}


    html, body, form, fieldset, legend, ol, li {
      margin: 0;
      padding: 0;
    }
    body {
      background: #ffffff;
      color: #111111;
      font-family: 맑은고딕,굴림,돋움;
      padding: 20px;
    }

    form {
      background: #9cbc2c;
      -moz-border-radius: 5px;
      -webkit-border-radius: 5px;
      -khtml-border-radius: 5px;
      border-radius: 5px;
      counter-reset: fieldsets;
      padding: 20px;
      width: 50%;

    }


    form fieldset {
      border: none;
      margin-bottom: 10px;
    }

    form fieldset:last-of-type {
      margin-bottom: 0;
    }

    form legend {
      color: #384313;
      font-size: 16px;
      font-weight: bold;
      padding-bottom: 10px;
      text-shadow: 0 1px 1px #c0d576;
    }

    form > fieldset > legend:before {
      content: "Step " counter(fieldsets) ": ";
      counter-increment: fieldsets;
    }

    form fieldset fieldset legend {
      color: #111111;
      font-size: 13px;
      font-weight: normal;
      padding-bottom: 0;
    }

    form ol li {
      background: #b9cf6a;
      background: rgba(255,255,255,.3);
      border-color: #e3ebc3;
      border-color: rgba(255,255,255,.6);
      border-style: solid;
      border-width: 2px;
      -moz-border-radius: 5px;
      -webkit-border-radius: 5px;
      -khtml-border-radius: 5px;
      border-radius: 5px;
      line-height: 30px;
      list-style: none;
      padding: 5px 10px;
      margin-bottom: 2px;
    }

    form ol ol li {
      background: none;
      border: none;
      float: left;
    }

    form label {
      float: left;
      font-size: 13px;
      width: 110px;
    }

    form fieldset fieldset label {
      background:none no-repeat left 50%;
      line-height: 20px;
      padding: 0 0 0 30px;
      width: auto;
    }


    form fieldset fieldset label:hover {
      cursor: pointer;
    }

    form input:not([type=radio]) {
      background: #ffffff;
      border: none;
      -moz-border-radius: 3px;
      -webkit-border-radius: 3px;
      -khtml-border-radius: 3px;
      border-radius: 3px;
      font: italic 13px 맑은고딕,굴림,돋움;
      outline: none;
      padding: 5px;
      width: 200px;
    }

    form input:not([type=submit]):focus, {
      background: #eaeaea;
    }


    form button {
      background: #384313;
      border: none;
      -moz-border-radius: 20px;
      -webkit-border-radius: 20px;
      -khtml-border-radius: 20px;
      border-radius: 20px;
      color: #ffffff;
      display: block;
      font: 16px 맑은고딕,굴림,돋움;
      letter-spacing: 1px;
      margin: auto;
      padding: 7px 25px;
      text-shadow: 0 1px 1px #000000;
      text-transform: uppercase;
    }

    form button:hover {
      background: #1e2506;
      cursor: pointer;
    }


  </style>




</head>
<body>

<div>
  <form:form modelAttribute="user">
    <legend>회원 가입</legend>
    <ol>
      <li>
        <label for="name">이름</label>
        <form:input path="name"/><br/>
      </li>

      <li>
        <label for="email">email</label>
        <form:input path="email"/><br/>
      </li>

      <li>
        <label for="password">비밀번호</label>
        <form:password path="password"/><br/>
      </li>

      <li>
        <label for="age">나이</label>
        <form:input path="age"/><br/>
      </li>
    </ol>
    <input type="submit" value="Signup"/>
  </form:form>


</div>



<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
<script src="/resources/js/bootstrap.min.js"></script>

</body>
</html>

