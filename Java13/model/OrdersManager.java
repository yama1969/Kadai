package Java13.model;

import java.util.ArrayList;
import java.util.Calendar;

import Java13.beans.Order;

public class OrdersManager {
    private ArrayList<Order> orders = new ArrayList<Order>();
    
    //注文登録
    public int add(Order newOrder){
        newOrder.setDatetime(Calendar.getInstance());
        orders.add(newOrder);
        newOrder.setNo(orders.size());
        return orders.size();
    }
    
    //注文検索
    public ArrayList<Order> search(){
        return orders;
    }

}
