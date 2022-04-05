package Java11;

import java.util.ArrayList;
import java.util.Calendar;

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
