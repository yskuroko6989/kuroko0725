<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Todoリスト</title>
</head>
<body>
<h1>ーーTodoリストーー</h1>

<form action = "/todo/Login" method = "post">
  ユーザ名：<input type = "text" name = "name"><br>
  パスワード：<input type = "password" name = "pass"><br><br>
  <input type = "submit" value = "ログイン">
</form>
</body>
</html>