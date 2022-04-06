<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%!
    private String getDateStr(String sy, String sm, String sd){
        if(sy != null && sm != null && sd != null){
            if(!sy.equals("") && !sm.equals("") && !sd.equals("")){
                int y = Integer.parseInt(sy);
                int m = Integer.parseInt(sm);
                int d = Integer.parseInt(sd);
                Calendar cal = Calendar.getInstance();
                cal.set(y, m - 1, d);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                return sdf.format(cal.getTime());
            }
        }
        return null;
    }
%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <link rel="stylesheet" href="style.css">
    <meta charset="UTF-8">
    <title>課題Server02</title>
</head>
<body>
    <table>
        <tr>
            <td>売上番号</td>
            <td>
                <%
                    String sno = request.getParameter("orderno");
                    if(sno != null && !sno.equals("")){
                        int ono = Integer.parseInt(sno);
                        out.println(ono);
                    }
                %>
            </td>
        </tr>
        <tr>
            <td>自注文日</td>
            <td>
                <%
                    String sy = request.getParameter("startyear");
                    String sm = request.getParameter("startmonth");
                    String sd = request.getParameter("startday");
                    String symd = getDateStr(sy, sm, sd);
                    if(symd != null){
                        out.println(symd);
                    }
                %>
            </td>
        </tr>
        <tr>
            <td>至注文日</td>
            <td>
                <%
                    String ey = request.getParameter("endyear");
                    String em = request.getParameter("endmonth");
                    String ed = request.getParameter("endday");
                    String eymd = getDateStr(ey, em, ed);
                    if(eymd != null){
                        out.println(eymd);
                    }
                %>
            </td>
        </tr>
        <tr>
            <td>部分氏名</td>
            <td>
                <%
                    String name = request.getParameter("custname");
                    if(name != null && !name.equals("")){
                        out.println(name);
                    }
                %>
            </td>
        </tr>
        <tr>
            <td>電話番号</td>
            <td>
                <%
                    String tel = request.getParameter("tel");
                    if(tel != null && !tel.equals("")){
                        out.println(tel);
                    }
                %>
            </td>
        </tr>
        <tr>
            <td>部分商品名</td>
            <td>
                <%
                    String item = request.getParameter("itemname");
                    if(item != null && !item.equals("")){
                        out.println(item);
                    }
                %>
            </td>
        </tr>
    </table>
</body>
</html>