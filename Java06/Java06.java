package Java06;

import java.util.Scanner;

public class Java06 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        //商品配列を作る3個
        Item[] items = new Item[3];
        items[0] = new Item("P001", "基礎からのJava", 2880);
        items[1] = new Item("P002", "HTML&CSS/JavaScriptのきほんのきほん", 2460);
        items[2] = new Item("P003", "基礎からのサーブレット/JSP", 1880);

        System.out.print("検索語 => ");
        String key = in.nextLine();

        Item[] result = search(key, items);

        int cnt = 0;
        for(int i = 0; i < result.length; i++){
            if(result[i] != null){
                System.out.printf("%4s : %4d円 : %s\n", result[i].getCode(), result[i].getPrice(), result[i].getName());
                cnt++;
            }
        }
        if(cnt == 0){
            System.out.println("検索結果はありません");
        }
        in.close();
    }

    //検索
    static Item[] search(String key, Item[] items){
        Item[] result = new Item[items.length];

        int respos = 0;
        for(int i = 0; i < items.length; i++){
            if(items[i].getName().indexOf(key) >= 0){
                result[respos] = items[i];
                respos++;
            }
        }

        return result;
    }
}
