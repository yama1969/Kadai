package controller;

import java.io.IOException;
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

@WebServlet("/order.html")
public class OrderInput extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String key = req.getParameter("itemcode");
    
        ItemsManager im = new ItemsManager();
        Item keyitem = new Item(key, null, 0);
        ArrayList<Item> itemlist = null;
        String message = null;
        try {
            itemlist = im.search(keyitem);
        } catch (EmptyItemsConditionException e) {
            message = "（プログラム不正：検索条件が空）";
        } catch (NoItemsException e) {
            message = "商品の番号が違います";
        } catch (CannotSearchItemsException e) {
            message = "（商品検索不能）";
        }

        if(message != null){
            req.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/itemList.jsp").forward(req, resp);
        }else{
            req.setAttribute("item", itemlist.get(0));
            getServletContext().getRequestDispatcher("/order.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
}
