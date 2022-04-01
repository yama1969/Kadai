package Java04;

import java.util.Scanner;

public class Java04 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        //商品配列を作る3個
        Item[] items = new Item[3];
        items[0] = new Item();
        items[0].setCode("P001");
        items[0].setName("基礎からのJava");
        items[0].setPrice(2880);
        items[1] = new Item();
        items[1].setCode("P002");
        items[1].setName("HTML&CSS/JavaScriptのきほんのきほん");
        items[1].setPrice(2460);
        items[2] = new Item();
        items[2].setCode("P003");
        items[2].setName("基礎からのサーブレット/JSP");
        items[2].setPrice(1880);

        String cmd = "";
        while(!cmd.equals("q")){
            System.out.print("cmd(s|a|d|q) => ");
            cmd = in.nextLine();
            
            if(cmd.equals("s")){
                show(items);
            }else if(cmd.equals("a")){
                asc(items);
                show(items);
            }else if(cmd.equals("d")){
                desc(items);
                show(items);
            }
        }
        in.close();
    }

    //表示
    static void show(Item[] items){
        for(int i = 0; i < items.length; i++){
            System.out.printf("%4s : %4d円 : %s\n", items[i].getCode(), items[i].getPrice(), items[i].getName());
        }
        System.out.println("--------------------------------");
    }

    //ソート昇順
    static void asc(Item[] items){
        for(int end = 1; end < items.length; end++){
            Item curr = items[end];
            int ins = end - 1;
            for(; ins >= 0 && items[ins].getPrice() > curr.getPrice(); ins--){
                items[ins + 1] = items[ins];
            }
            items[ins + 1] = curr;
        }
    }

    //ソート降順
    static void desc(Item[] items){
        for(int end = 1; end < items.length; end++){
            Item curr = items[end];
            int ins = end - 1;
            for(; ins >= 0 && items[ins].getPrice() < curr.getPrice(); ins--){
                items[ins + 1] = items[ins];
            }
            items[ins + 1] = curr;
        }
    }
}
