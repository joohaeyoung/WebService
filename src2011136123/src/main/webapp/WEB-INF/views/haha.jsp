<%--
  Created by IntelliJ IDEA.
  User: haeyoungJoo
  Date: 2017-12-06
  Time: 오전 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="ko">
    
<head>

    <meta charset="utf-8">
            

            
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>사거리</title>
            <!-- Bootstrap -->
            
    <link href="/resources/css/bootstrap.css" rel="stylesheet" type="text/css"/>
            
    <link href="/resources/image/icon/HalfLife.ico" rel="shortcuticon">
            <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
            
    <script src="/code.jquery.com/jquery.js"></script>
            <!-- 모든 합쳐진 플러그인을 포함하거나 (아래) 필요한 각각의 파일들을 포함하세요 -->
            
    <script src="/resources/js/bootstrap.min.js"></script>
            <!-- Respond.js 으로 IE8 에서 반응형 기능을 활성화하세요 (https://github.com/scottjehl/Respond) -->
            
    <script src="/resources/js/respond.js"></script>
        
</head>
    
<body>
        
<div class="container"><!-- 좌우측의 공간 확보 -->
        
       <!-- 본문 들어가는 부분 -->
     <form:form modelAttribute="user" class="form-horizontal" role="form">
                   
        <div class="form-group">
                            <label for="provision" class="col-lg-2 control-label">회원가입약관</label>
                            
            <div class="col-lg-10" id="provision">
                                    <textarea class="form-control" rows="8" style="resize:none">
약관동의
김찬명 교수님의 WebServiceConmputing 수업에 오신것을 환영합니다
회원가입을 하시면 김찬명 교수님의 수업에 열심히 참여하여합니다.
수업시간에 엎드려 자는 행동은 금지합니다.
모르는 것이 있으면 질문합니다.
본인이 웹의 달인이라면 잘난척 하지말고 동료들에게 가르쳐줍니다.
                    </textarea>
                                    
                <div class="radio">
                                            <label>
                                                <input type="radio" id="provisionYn" name="provisionYn" value="Y"
                                                       autofocus="autofocus" checked>
                                                동의합니다.
                                            </label>
                                        
                </div>
                                    
                <div class="radio">
                                            <label>
                                                <input type="radio" id="provisionYn" name="provisionYn" value="N">
                                                동의하지 않습니다.
                                            </label>
                                        
                </div>
                                
            </div>
                        
        </div>
                    
        <div class="form-group">
                            <label for="memberInfo" class="col-lg-2 control-label">개인정보취급방침</label>
                            
            <div class="col-lg-10" id="memberInfo">
                                    <textarea class="form-control" rows="8" style="resize:none">
개인정보의 항목 및 수집방법
한국기술교육대학교 컴퓨터공학부 학생들인  이동석 주해용 송진수 박종희가 개인정보를 수집합니다.
아마존 웹서비스의 RDS 에 회원데이터를 저장합니다.
                    </textarea>
                                    
                <div class="radio">
                                            <label>
                                                <input type="radio" id="memberInfoYn" name="memberInfoYn" value="Y"
                                                       checked>
                                                동의합니다.
                                            </label>
                                        
                </div>
                                    
                <div class="radio">
                                            <label>
                                                <input type="radio" id="memberInfoYn" name="memberInfoYn" value="N">
                                                동의하지 않습니다.
                                            </label>
                                        
                </div>
                                
            </div>
                        
        </div>
                   
        <div class="form-group" id="divEmail">
            <label for="inputEmail" class="col-lg-2 control-label">이메일</label>
            <div class="col-lg-10">
                <form:input path="email" class="form-control" id="email" data-rule-required="true" placeholder="이메일"
                            maxlength="40" /><br/>

            </div>
        </div>
                   
        <div class="form-group" id="divPassword">
            <label for="inputPassword" class="col-lg-2 control-label">패스워드</label>
            <div class="col-lg-10">
                <form:password path="password" class="form-control" id="password" name="excludeHangul" data-rule-required="true"
                               placeholder="패스워드" maxlength="30"/><br/>
            </div>
        </div>
                 
        <div class="form-group" id="divPasswordCheck">
            <label for="inputPasswordCheck" class="col-lg-2 control-label">패스워드 확인</label>
            <div class="col-lg-10">
                <input type="password" class="form-control" id="passwordCheck" data-rule-required="true"
                       placeholder="패스워드 확인" maxlength="30">
            </div>
        </div>
                     
        <div class="form-group" id="divName">
            <label for="inputName" class="col-lg-2 control-label">이름</label>
            <div class="col-lg-10">
                <form:input path="name" class="form-control onlyHangul" id="name" data-rule-required="true"
                            placeholder="한글만 입력 가능합니다." maxlength="15"/><br/>
                <!--<input type="text" class="form-control onlyHangul" id="name" data-rule-required="true"
                       placeholder="한글만 입력 가능합니다." maxlength="15">-->
            </div>
        </div>
              
        <div class="form-group" id="divAge">
            <label for="inputAge" class="col-lg-2 control-label">나이</label>
            <div class="col-lg-10">
                <form:input path="age" class="form-control " id="age" data-rule-required="true"
                            placeholder="나이" maxlength="15"/><br/>
            </div>
        </div>
                    
                    
        <div class="form-group">
                            
            <div class="col-lg-offset-2 col-lg-10">
                                    
                <input type="submit" value="Signup"/>
                             
            </div>
                        
        </div>
    </form:form>

         <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="/resources/js/bootstrap.min.js"></script>

    <script>

        $(function () {
            //------- validation 검사
            $("form").submit(function (event) {

                var provision = $('#provision');
                var memberInfo = $('#memberInfo');
                var divEmail = $('#divEmail');
                var divPassword = $('#divPassword');
                var divPasswordCheck = $('#divPasswordCheck');
                var divName = $('#divName');
                var divAge = $('#divAge');



                //회원가입약관
                if ($('#provisionYn:checked').val() == "N") {
                    modalContents.text("회원가입약관에 동의하여 주시기 바랍니다."); //모달 메시지 입력
                    modal.modal('show'); //모달 띄우기

                    provision.removeClass("has-success");
                    provision.addClass("has-error");
                    $('#provisionYn').focus();
                    return false;
                } else {
                    provision.removeClass("has-error");
                    provision.addClass("has-success");
                }

                //개인정보취급방침
                if ($('#memberInfoYn:checked').val() == "N") {
                    modalContents.text("개인정보취급방침에 동의하여 주시기 바랍니다.");
                    modal.modal('show');

                    memberInfo.removeClass("has-success");
                    memberInfo.addClass("has-error");
                    $('#memberInfoYn').focus();
                    return false;
                } else {
                    memberInfo.removeClass("has-error");
                    memberInfo.addClass("has-success");
                }

                //이메일
                if ($('#email').val() == "") {
                    modalContents.text("이메일을 입력하여 주시기 바랍니다.");
                    modal.modal('show');

                    divEmail.removeClass("has-success");
                    divEmail.addClass("has-error");
                    $('#email').focus();
                    return false;
                } else {
                    divEmail.removeClass("has-error");
                    divEmail.addClass("has-success");
                }

                //패스워드 검사
                if ($('#password').val() == "") {
                    modalContents.text("패스워드를 입력하여 주시기 바랍니다.");
                    modal.modal('show');

                    divPassword.removeClass("has-success");
                    divPassword.addClass("has-error");
                    $('#password').focus();
                    return false;
                } else {
                    divPassword.removeClass("has-error");
                    divPassword.addClass("has-success");
                }

                //패스워드 확인
                if ($('#passwordCheck').val() == "") {
                    modalContents.text("패스워드 확인을 입력하여 주시기 바랍니다.");
                    modal.modal('show');

                    divPasswordCheck.removeClass("has-success");
                    divPasswordCheck.addClass("has-error");
                    $('#passwordCheck').focus();
                    return false;
                } else {
                    divPasswordCheck.removeClass("has-error");
                    divPasswordCheck.addClass("has-success");
                }

                //패스워드 비교
                if ($('#password').val() != $('#passwordCheck').val() || $('#passwordCheck').val() == "") {
                    modalContents.text("패스워드가 일치하지 않습니다.");
                    modal.modal('show');

                    divPasswordCheck.removeClass("has-success");
                    divPasswordCheck.addClass("has-error");
                    $('#passwordCheck').focus();
                    return false;
                } else {
                    divPasswordCheck.removeClass("has-error");
                    divPasswordCheck.addClass("has-success");
                }

                //이름
                if ($('#name').val() == "") {
                    modalContents.text("이름을 입력하여 주시기 바랍니다.");
                    modal.modal('show');

                    divName.removeClass("has-success");
                    divName.addClass("has-error");
                    $('#name').focus();
                    return false;
                } else {
                    divName.removeClass("has-error");
                    divName.addClass("has-success");
                }

                //나이
                if ($('#age').val() == "") {
                    modalContents.text("이름을 입력하여 주시기 바랍니다.");
                    modal.modal('show');

                    divAge.removeClass("has-success");
                    divAge.addClass("has-error");
                    $('#age').focus();
                    return false;
                } else {
                    divAge.removeClass("has-error");
                    divAge.addClass("has-success");
                }

            });

        });

    </script>
                    <!--// 본문 들어가는 부분 -->
                
    <hr/>
                <!-- 푸터 들어가는 부분 -->
                 
              
            
</div>
    
</body>
</html>