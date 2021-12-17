<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "model.User,model.MutterList,java.util.List" %>
    <%
    User loginUser = (User) session.getAttribute("loginUser");
   List<MutterList> mutterList = (List<MutterList>) request.getAttribute("mutterList");
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
#botton{
display: block;
}
</style>
<script type="text/javascript">
function dataCheck(obj) {
	var msg = "";
	var date1 = new Date(obj.day.value);
    var date2 = new Date();
	if(obj.text.value.length < 1){
		msg += "やることを入力してください。\n";
	}

	if(date1 < date2 || date1.getYear() < date2.getYear()){
		msg += "過去日です。\n";
	}
	if(date1 == null){
		msg += "正しい日付を入力してください。\n";
	}


	if(msg.length > 0){
		alert(msg);
		return false;
	}
	return true;
}
</script>
<meta charset="UTF-8">
<title>ToDo</title>
</head>
<body>
<h1>ToDoリスト</h1>
<p>
<%= loginUser.getName() %>さん、ログイン中
<form action = "/todo/Logout" method = "post">
<input type = "submit" value = "ログアウト">
</form>
</p>
<p>※当日以降の日付で入力してください</p>
<form action = "/todo/Mutter" method = "post" onsubmit="return dataCheck(this);">
 <input type = "text" name = "text"/>
 <input type = "date" name = "day"/>
 <input type = "hidden" name = "mode" value="1"/>
 <input type = "submit" value = "追加"/>
</form>
<br>
<% for(MutterList mutter : mutterList){ %>



  <form action="/todo/Mutter" method = "post" >
  <input type = "checkbox">
  <%= mutter.getDate() %>    <%= mutter.getText() %>
    <input type = "hidden" name = "mode" value = "2">
    <input type = "hidden" name = "id" value = "<%= mutter.getId()%>">
    <input type = "submit" value = "削除">
  </form>


<%} %>



</body>
</html>