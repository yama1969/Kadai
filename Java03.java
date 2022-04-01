import java.util.Scanner;

class Java03{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        //商品配列を作る3個
        String[] codes = {"P001", "P002", "P003"};
        String[] names = {"基礎からのJava", "HTML&CSS/JavaScriptのきほんのきほん", "基礎からのサーブレット/JSP"};
        int[] prices = {2880, 2460, 1880};

        String cmd = "";
        while(!cmd.equals("q")){
            System.out.print("cmd(s|a|d|q) => ");
            cmd = in.nextLine();
            
            if(cmd.equals("s")){
                show(codes, names, prices);
            }else if(cmd.equals("a")){
                asc(codes, names, prices);
                show(codes, names, prices);
            }else if(cmd.equals("d")){
                desc(codes, names, prices);
                show(codes, names, prices);
            }
        }
        in.close();
    }

    //表示
    static void show(String[] codes, String[] names, int[] prices){
        for(int i = 0; i < codes.length; i++){
            System.out.printf("%4s : %4d円 : %s\n", codes[i], prices[i], names[i]);
        }
        System.out.println("--------------------------------");
    }

    //ソート昇順
    static void asc(String[] codes, String[] names, int[] prices){
        for(int end = 1; end < prices.length; end++){
            String curr_code = codes[end];
            String curr_name = names[end];
            int curr_price = prices[end];
            
            int ins = end - 1;
            for(; ins >= 0 && prices[ins] > curr_price; ins--){
                codes[ins + 1] = codes[ins];
                names[ins + 1] = names[ins];
                prices[ins + 1] = prices[ins];
            }
            codes[ins + 1] = curr_code;
            names[ins + 1] = curr_name;
            prices[ins + 1] = curr_price;
        }
    }

    //ソート降順
    static void desc(String[] codes, String[] names, int[] prices){
        for(int end = 1; end < prices.length; end++){
            String curr_code = codes[end];
            String curr_name = names[end];
            int curr_price = prices[end];
            
            int ins = end - 1;
            for(; ins >= 0 && prices[ins] < curr_price; ins--){
                codes[ins + 1] = codes[ins];
                names[ins + 1] = names[ins];
                prices[ins + 1] = prices[ins];
            }
            codes[ins + 1] = curr_code;
            names[ins + 1] = curr_name;
            prices[ins + 1] = curr_price;
        }
    }
}