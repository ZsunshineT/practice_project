package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by zhangteng on 2021/1/5.
 */
public class ConvertToBase7 {
    public static void main(String[] args) {
        int n = 0;
        System.out.println(convertToBase7(n));
    }

    private static String convertToBase7(int num) {
        int m = 0;
        int n = 0;
        String result = "";
        List<Integer> resultList = new ArrayList<>();
        if(num < 0){
            n = -num;
        }else{
            n = num;
        }
        while(n/7 >= 0){
            m = n%7;
            resultList.add(m);
            n = n/7;
            if(n == 0){
                break;
            }

        }
        for(int j=resultList.size()-1;j>=0;j--){
            result =result + resultList.get(j);
        }
        if(num < 0){
            result = "-"+result;
        }
        return result;
    }

}
