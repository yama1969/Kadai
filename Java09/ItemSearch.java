package Java09;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemSearch {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("商品コード条件 => ");
        String code = in.nextLine();
        System.out.print("商品名条件 => ");
        String name = in.nextLine();

        Item key = new Item(code, name, 0);
        
        ItemsManager im = new ItemsManager();
        ArrayList<Item> result = im.search(key);

        if(result == null){
            System.out.println("検索条件が未入力です。");
        }else if(result.size() == 0){
            System.out.println("検索結果はありません");
        }else{
            for(int i = 0; i < result.size(); i++){
                Item curr = result.get(i);
                if(result.get(i) != null){
                    System.out.printf("%4s : %4d円 : %s\n", curr.getCode(), curr.getPrice(), curr.getName());
                }
            }
        }            

        in.close();
    }
}
