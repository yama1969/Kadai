<%@ page contentType="text/html;charset=UTF-8"
    import="model.ItemsManager"
    import="beans.Item"
    import="java.util.ArrayList"
%>
<%
    request.setCharacterEncoding("UTF-8");
    String key = request.getParameter("itemname");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <link rel="stylesheet" href="style.css">
    <meta charset="UTF-8">
    <title>課題Server03</title>
</head>
<body>
    <h1>JSPからJavaクラスを利用する</h1>
<%
    ItemsManager im = new ItemsManager();
    Item keyitem = new Item(null, key, 0);
    ArrayList<Item> list = im.search(keyitem);
%>
    <table>
        <tr><th>商品コード</th><th>商品名</th><th>価格</th></tr>
<%
    for(Item item : list){
%>
        <tr>
            <td><%=item.getCode()%></td>
            <td><%=item.getName()%></td>
            <td><%=item.getPrice()%></td>
        </tr>
<%
    }
%>
    </table>        
</body>
</html>