<%@ page contentType="text/html;charset=UTF-8"
    import="javax.naming.Context"
    import="javax.naming.InitialContext"
    import="javax.sql.DataSource"
    import="java.sql.Connection"
    import="java.sql.ResultSet"
    import="java.sql.PreparedStatement"
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
    <h1>データベース接続</h1>
<%
    Context context = new InitialContext();
    DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/goodsorder");
    try(Connection db = ds.getConnection()){
        PreparedStatement ps = db.prepareStatement("SELECT code, name, price FROM items WHERE  name LIKE ? ORDER BY code");
        ps.setString(1, "%" + key + "%");
        ResultSet rs = ps.executeQuery();
%>
    <table>
        <tr><th>商品コード</th><th>商品名</th><th>価格</th></tr>
<%
        while(rs.next()){
%>
        <tr>
            <td><%=rs.getString("code")%></td>
            <td><%=rs.getString("name")%></td>
            <td><%=rs.getInt("price")%></td>
        </tr>
<%
        }
    }
%>
    </table>        
</body>
</html>