<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="java.util.ArrayList"
        import="beans.Item"
%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="style.css">
  <title>商品一覧：書籍販売システム</title>
</head>
<body>
<section id="contents">
  <h1>書籍販売システム</h1>
  <h2>商品一覧</h2>
  <table>
    <tr>
      <th>番号</th><th>書籍名</th><th>価格</th><th>注文</th>
    </tr>
 <%
ArrayList<Item> itemlist = (ArrayList<Item>)request.getAttribute("itemlist");
 for(int i = 0; i < itemlist.size(); i++){
    Item item = itemlist.get(i);
%>
    <tr>
      <td><%=(i + 1) %></td><td><%=item.getName() %></td><td><%=item.getPrice() %>円</td><td><button type="button">注文</button></td>
    </tr>
<%
}
%>
  </table>
  <form class="input" action="start.jsp"><button type="submit">トップへ戻る</button></form>
  </section>
</body>
</html>
