<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2>anno.jsp</h2>
  <form action="/ehr/anno/do_select_one.do" method="POST">
    <label>아이디</label>
    <input type="text" name="userId" id="userId" >
    <label>비번 </label>
    <input type="password" name="passwd" id="passwd"></input>
    <input type="submit" vlaue="전송">
  </form>
  <b>${message}</b><br>
  userId:${userId}<br>
  passwd:${passwd}
</body>
</html>