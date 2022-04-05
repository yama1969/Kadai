package Java08;

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
        Item[] result = im.search(key);

        if(result == null){
            System.out.println("検索条件が未入力です。");
        }else{
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
        }

        in.close();
    }
}
