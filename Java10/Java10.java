package Java10;

import java.util.Calendar;
import java.util.Scanner;

public class Java10 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        //日付入力
        String[] s_date = new String[2];
        for(int i = 0; i < s_date.length; i++){
            System.out.print("日付" + (i + 1) + "(yyyymmdd) => ");
            s_date[i] = in.nextLine();
        }
        
        //日付変換
        Calendar[] cal = new Calendar[2];
        for(int i = 0; i < cal.length; i++){
            cal[i] = Calendar.getInstance();
            String year = s_date[i].substring(0, 4);
            String month = s_date[i].substring(4, 6);
            String date = s_date[i].substring(6, 8);
            cal[i].set(Calendar.YEAR, Integer.parseInt(year));
            cal[i].set(Calendar.MONTH, Integer.parseInt(month) - 1);
            cal[i].set(Calendar.DATE, Integer.parseInt(date));
        }
        
        //現在日時との比較
        Calendar now = Calendar.getInstance();
        if(now.before(cal[0])){
            System.out.println("前");
        }else if(now.after(cal[1])){
            System.out.println("後");
        }else{
            System.out.println("間");
        }
        
        in.close();
    }
}
