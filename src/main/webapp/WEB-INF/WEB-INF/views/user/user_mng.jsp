<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>         
<body> 


        <table border="1">
          <tr>
            <td>NO</td>
            <td>아이디</td>
            <td>이름</td>
            <td>등급</td>
            <td>이메일</td>
            <td>등록일</td>
          </tr>
          <c:forEach var="vo" items="${list}">
           <tr>
            <td>${vo.num}</td>
            <td>${vo.userId}</td>
            <td>${vo.name}</td>
            <td>${vo.level}</td>
            <td>${vo.email}</td>
            <td>${vo.reg_dt}</td>
           </tr>
          </c:forEach>
            <%
            
            
            
            %>        
          
        </table>
        


</body>
</html>