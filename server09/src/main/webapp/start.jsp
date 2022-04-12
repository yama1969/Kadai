<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="style.css">
  <title>商品検索：書籍販売システム</title>
</head>
<body>
<section id="contents">
  <h1>書籍販売システム</h1>
  <h2>商品検索</h2>
<%
String message = (String)request.getAttribute("message");
if(message != null && !message.equals("")){
%>
  <p><%=message %></p>
<%    
}
%>
  <p>検索する書籍名を入力してください。書籍名の一部分でも検索できます。</p>
  <form id="searchform" class="input" action="itemList.html" method="post">
    書籍名：<input type="text" name="itemname"><button id="search" type="button">検索</button>
  </form>
  <form class="input" action="staff.html"><button type="button">店員メニュー</button></form>
</section>
</body>
<script>
  document.getElementById("search").addEventListener('click', function(){
    var box = document.getElementsByTagName("input");
    var empty = 1;
    for(var i = 0; i < box.length; i++){
      if(box[i].value != ""){
        empty = 0;
      }
    }
    if(empty == 1){
      window.alert("1つも入力されていません");
    }else{
      document.getElementById("searchform").submit();
    }
  });
</script>
</html>
