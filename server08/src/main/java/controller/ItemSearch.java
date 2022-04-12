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

        if(message != null){
            req.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/start.jsp").forward(req, resp);
        }else{
            req.setAttribute("itemlist", itemlist);
            getServletContext().getRequestDispatcher("/itemList.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
