package controller;

import java.util.ArrayList;
import java.util.Scanner;

import beans.Item;
import beans.Order;
import exceptions.EmptyItemsConditionException;
import exceptions.NoItemsException;
import model.ItemsManager;
import model.OrdersManager;

public class OrderAdd {
    private static OrdersManager om = new OrdersManager();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args){
        Item orderItem = null;
        while((orderItem = inputOrderItem()) != null){  //注文商品コード入力
            inputOrder(orderItem);                      //注文情報入力
            showOrder();                                //注文一覧表示
        }

        in.close();
    }

    //注文商品コード入力
    private static Item inputOrderItem(){
        System.out.print("注文する商品のコード => ");
        String code = in.nextLine();
        Item orderitem = new Item(code, null, 0);

        //注文商品の情報を得る
        ItemsManager im = new ItemsManager();
        ArrayList<Item> itemlist = null;
        try{
            itemlist = im.search(orderitem);
        }catch(EmptyItemsConditionException e){
            System.out.println("商品コードが入力されていません。");
            return null;
        }catch(NoItemsException e){
            System.out.println("該当する商品はありません。");
            return null;
        }
        return itemlist.get(0);
    }

    //注文情報の入力と登録
    private static void inputOrder(Item orderitem){
        Order neworder = new Order();
        System.out.printf("%4s : %4d円 : %s\n", orderitem.getCode(), orderitem.getPrice(), orderitem.getName());
        neworder.setItem(orderitem);
        System.out.print("(*)個数 => ");
        String indat = in.nextLine();
        neworder.setQuantity(Integer.parseInt(indat));
        System.out.print("(*)お名前(姓) => ");
        indat = in.nextLine();
        neworder.setSei(indat);
        System.out.print("(*)お名前(名) => ");
        indat = in.nextLine();
        neworder.setMei(indat);
        System.out.print("(*)ご住所(都道府県) => ");
        indat = in.nextLine();
        neworder.setPref(indat);
        System.out.print("(*)ご住所(市区郡以降) => ");
        indat = in.nextLine();
        neworder.setAdd(indat);
        System.out.print("お電話番号 => ");
        indat = in.nextLine();
        neworder.setTel(indat);
        System.out.print("メールアドレス => ");
        indat = in.nextLine();
        neworder.setMail(indat);
        om.add(neworder);
    }
    
    //注文の表示
    private static void showOrder(){
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println(" 注文一覧");
        System.out.println("--------------------------------------------------------------------------------");
        ArrayList<Order> orderlist = om.search();
        for(int i = 0; i < orderlist.size(); i++){
            Order order = orderlist.get(i);
            System.out.print(order.getNo() + ":");
            Item item = order.getItem();
            System.out.print(item.getCode() + ":");
            System.out.print(item.getName() + ":");
            System.out.print(item.getPrice() + ":");
            System.out.print(order.getQuantity() + ":");
            System.out.print(order.getSei() + order.getMei() + ":");
            System.out.print(order.getPref() + order.getAdd() + ":");
            System.out.print(order.getTel() + ":");
            System.out.println(order.getMail() + ":");
        }
        System.out.println("--------------------------------------------------------------------------------");
    }
}
