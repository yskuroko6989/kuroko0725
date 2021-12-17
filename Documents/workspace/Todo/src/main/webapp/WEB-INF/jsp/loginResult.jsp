<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "model.User" %>
    <%
     User loginUser = (User) session.getAttribute("loginUser");
    %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
  width:100%; /*ページ全体の幅は100%と指定する*/
  text-align:center; /*ページ全体を中央揃えにする*/
  background-color: #f5deb3;
}

h1{
margin-top: 100px;
display: inline-block;
border-top: 4px solid #deb887;
border-bottom: 4px solid #deb887;
}
</style>
<meta charset="UTF-8">
<title>ToDo</title>
</head>
<body>

<h1>ToDoログイン</h1>
<%if(loginUser != null){ %>
<P>ログインに成功しました</P>
<p>ようこそ<%= loginUser.getName() %>さん</p>
<form action="/todo/Main" method = "post">
<input type = "submit" value = "ToDoリストへ">
</form>

<%}else{ %>
  <P>ログインに失敗しました</P>
  <form action="/todo/" method = "post">
<input type = "submit" value = "トップへ">
</form>
<%} %>
</body>
</html>