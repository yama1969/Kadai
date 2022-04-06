<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <link rel="stylesheet" href="style.css">
    <meta charset="UTF-8">
    <title>課題Server01</title>
</head>
<body>
    <h1><%= request.getParameter("itemname")%></h1>
</body>
</html>