<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.ArrayList"
        import="beans.Item"
%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="style.css">
  <title>商品注文：書籍販売システム</title>
</head>
<body>
<section id="contents">
  <h1>書籍販売システム</h1>
  <h2>商品注文</h2>
<%
String message = (String)request.getAttribute("message");
if(message != null && !message.equals("")){
%>
  <p>
    <%=message %>
  </p>
<%
}
%>
  <p>
    注文情報をご入力ください。<br>
    ※印は必須項目です。
  </p>
  <form class="input">
<%
Item item = (Item)request.getAttribute("item");
%>
      商品名：<%=item.getName() %><br>
      価格：<%=item.getPrice() %>円<br>
      ※ご注文個数：<input type="number" name="quantity"><br>
      ※お名前：(姓)<input type="text" name="sei">(名)<input type="text" name="mei"><br>
      ※ご住所：(都道府県)<input type="text" name="pref">(市区郡以降)<input type="text" name="address"><br>
      お電話番号：<input type="tel" name="tel"><br>
      メールアドレス：<input type="email" name="mail"><br>
      <button type="button">注文確定</button>
  </form>
  <form class="input" action="start.jsp"><button type="submit">トップへ戻る</button></form>
  </section>
</body>
</html>
