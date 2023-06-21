<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- jsp comment:html comment가 노출 되지 않음

 --%>
<c:set var="CP" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${CP}/resources/js/jquery-3.7.0.js"></script>
	<script>
	$(document).ready(function(){ //모든 화면이다 로딩이 되면
		console.log("$(document).ready")
		
		//jquery이벤트 감지
		$("#doLogin").on("click",function(){
			 console.log("$(doLogin)")
			 
			 console.log("userId:"+$('#userId').val());
       console.log("passwd:"+$('#passwd').val());
			
			if (confirm('로그인 하시겠습니까?')==false)return;
				

			 
			 $.ajax({
			        type: "POST",
			        url:"${CP}/login/doLogin.do",
			        dataType:"html",
			        data:{
			        	userId:$('#userId').val(),
			          passwd:$('#passwd').val()  
			        },
			        success:function(data){//통신 성공
			        	
			        	
			        	  let paredJSON = JSON.parse(data)
			        	  console.log("paredJSON.msgId:"+paredJSON.megId);
			           // console.log("success data:"+data);
			           
			           if("1" == paredJSON.megId || "10" == paredJSON.megId){
			        	   alert(paredJSON.msgContents);
			        	   //jquery focus
			        	   $('#userId').focus();
			        	   return;
			           }
			           
                 if("2" == paredJSON.megId || "20" == paredJSON.megId){
                     alert(paredJSON.msgContents);
                     //jquery focus
                     $('#userId').focus();
                     return;
                   }
                 
                 console.log("paredJSON.msgContents:"+paredJSON.msgContents);
                 //로그인 성공
                 if("30" == paredJSON.megId ){
                     alert(paredJSON.msgContents);
                     
                     //javascript 내장 객체: url
                     window.location.href ="${CP}/user/doRetrieve.do";
                 }  
                 
                 
                 
                 
			          },
			          error:function(data){//실패시 처리
			            console.log("error:"+data);
			          }
			      });
			
			
		})//--doLogin end
		
		
	});//--end document
	</script>
</head>
<body>

  <div>
    <h2>로그인</h2>
    <!-- form  -->
    <form action="${CP}/login/doLogin.do" method="post">
     <div>
      <label for="">아이디</label>
      <input type="text" id="userId" name="userId" maxlength="20">
     </div>
          <div>
      <label for="">비번</label>
      <input type="password" id="passwd" name="passwd" maxlength="100">
     </div>
     <div>
      <input type="button" value="로그인" id="doLogin">
     </div>
   </form> 
    
    
    
    <!-- form end -->
  </div>
  
</body>
</html>