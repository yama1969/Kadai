import java.util.Scanner;

class Java02{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        //料金の配列を作る20個
        int[] prices = new int[20];
        for(int i = 0; i < prices.length; i++){
            prices[i] = ((int)(Math.random() * 900) + 100) * 10;
        }

        String cmd = "";
        while(!cmd.equals("q")){
            System.out.print("cmd(s|a|d|q) => ");
            cmd = in.nextLine();
            
            if(cmd.equals("s")){
                show(prices);
            }else if(cmd.equals("a")){
                asc(prices);
                show(prices);
            }else if(cmd.equals("d")){
                desc(prices);
                show(prices);
            }
        }
        in.close();
    }

    //表示
    static void show(int[] prices){
        for(int i = 0; i < prices.length; i++){
            System.out.printf("%3d : %4d円\n", i + 1, prices[i]);
        }
        System.out.println("--------------------------------");
    }

    //ソート昇順
    static void asc(int[] prices){
        for(int end = 1; end < prices.length; end++){
            int curr = prices[end];
            int ins = end - 1;
            for(; ins >= 0 && prices[ins] > curr; ins--){
                prices[ins + 1] = prices[ins];
            }
            prices[ins + 1] = curr;
        }
    }

    //ソート降順
    static void desc(int[] prices){
        for(int end = 1; end < prices.length; end++){
            int curr = prices[end];
            int ins = end - 1;
            for(; ins >= 0 && prices[ins] < curr; ins--){
                prices[ins + 1] = prices[ins];
            }
            prices[ins + 1] = curr;
        }
    }
}