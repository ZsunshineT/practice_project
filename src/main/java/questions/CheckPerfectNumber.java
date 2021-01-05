package questions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description:
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 * Created by zhangteng on 2021/1/4.
 */
public class CheckPerfectNumber {
    public static void main(String[] args) {
        int num = 28;
        List<Integer> temp = new ArrayList<Integer>();
        long startTime = new Date().getTime();
        System.out.println(checkPerfectNumber(num));
        long endTime = new Date().getTime();
        System.out.println(endTime-startTime);
    }

    private static boolean checkPerfectNumber(int num) {
        int sum = 0;
        if(num < 2){
            return false;
        }else{
            for(int i=2;i<=Math.sqrt(num);i++){
                if(num%i == 0){
                    sum = sum + i + num/i;
                }
            }
            sum = sum + 1;
            if(sum == num && num != 1){
                return true;
            }
        }
        return false;
    }
}
