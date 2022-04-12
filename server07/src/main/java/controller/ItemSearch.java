package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Item;
import exceptions.CannotSearchItemsException;
import exceptions.EmptyItemsConditionException;
import exceptions.NoItemsException;
import model.ItemsManager;

@WebServlet("/itemList.html")
public class ItemSearch extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String key = req.getParameter("itemname");
    
        ItemsManager im = new ItemsManager();
        Item keyitem = new Item(null, key, 0);
        ArrayList<Item> itemlist = null;
        String message = null;
        try {
            itemlist = im.search(keyitem);
        } catch (EmptyItemsConditionException e) {
            message = "検索語が入力されていません";
        } catch (NoItemsException e) {
            message = "検索結果はありません";
        } catch (CannotSearchItemsException e) {
            message = "検索できませんでした。やり直してください。";
        }

        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        if(message != null){
            showS01(out, message);
        }else{
            showS02(out, itemlist);
        }
    }

    private void showS01(PrintWriter out, String message){
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"ja\">");
        out.println("<head>");
        out.println("  <meta charset=\"UTF-8\">");
        out.println("  <link rel=\"stylesheet\" href=\"style.css\">");
        out.println("  <title>商品検索：書籍販売システム</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<section id=\"contents\">");
        out.println("  <h1>書籍販売システム</h1>");
        out.println("  <h2>商品検索</h2>");
        out.println("  <p>" + message + "</p>");
        out.println("  <p>検索する書籍名を入力してください。書籍名の一部分でも検索できます。</p>");
        out.println("  <form id=\"searchform\" class=\"input\" action=\"itemList.html\" method=\"post\">");
        out.println("    書籍名：<input type=\"text\" name=\"itemname\"><button id=\"search\" type=\"button\">検索</button>");
        out.println("  </form>");
        out.println("  <form class=\"input\" action=\"staff.html\"><button type=\"button\">店員メニュー</button></form>");
        out.println("</section>");
        out.println("</body>");
        out.println("<script>");
        out.println("  document.getElementById(\"search\").addEventListener('click', function(){");
        out.println("    var box = document.getElementsByTagName(\"input\");");
        out.println("    var empty = 1;");
        out.println("    for(var i = 0; i < box.length; i++){");
        out.println("      if(box[i].value != \"\"){");
        out.println("        empty = 0;");
        out.println("      }");
        out.println("    }");
        out.println("    if(empty == 1){");
        out.println("      window.alert(\"1つも入力されていません\");");
        out.println("    }else{");
        out.println("      document.getElementById(\"searchform\").submit();");
        out.println("    }");
        out.println("  });");
        out.println("</script>");
        out.println("</html>");
    }

    private void showS02(PrintWriter out, ArrayList<Item> itemlist){
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"ja\">");
        out.println("<head>");
        out.println("  <meta charset=\"UTF-8\">");
        out.println("  <link rel=\"stylesheet\" href=\"style.css\">");
        out.println("  <title>商品一覧：書籍販売システム</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<section id=\"contents\">");
        out.println("  <h1>書籍販売システム</h1>");
        out.println("  <h2>商品一覧</h2>");
        out.println("  <table>");
        out.println("    <tr>");
        out.println("      <th>番号</th><th>書籍名</th><th>価格</th><th>注文</th>");
        out.println("    </tr>");
        for(int i = 0; i < itemlist.size(); i++){
            Item item = itemlist.get(i);
            out.println("    <tr>");
            out.print(  "      <td>" + (i + 1) + "</td><td>" + item.getName() + "</td><td>" + item.getPrice() + "円</td>");
            out.println("<td><button type=\"button\">注文</button></td>");
            out.println("    </tr>");
        }
        out.println("  </table>");
        out.println("  <form class=\"input\" action=\"start.html\"><button type=\"submit\">トップへ戻る</button></form>");
        out.println("</section>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
}
