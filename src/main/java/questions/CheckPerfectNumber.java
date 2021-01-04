package questions;

import java.util.Date;

/**
 * Description:
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * 给定一个 整数 n， 如果是完美数，返回 true，否则返回 false
 * Created by zhangteng on 2021/1/4.
 */
public class CheckPerfectNumber {
    public static void main(String[] args) {
        int num = 28;
        int sum = 0;
        long startTime = new Date().getTime();
        System.out.println(checkPerfectNumber1(num,sum));
        long endTime = new Date().getTime();
        System.out.println(endTime-startTime);
    }

    private static boolean checkPerfectNumber(int num) {
        int sum = 0;
        for(int i=1;i<=num/2;i++){
            if(num%i == 0){
                sum = sum + i;
            }
        }
        if(sum == num && num != 1){
            return true;
        }
        return false;
    }
    private static int checkPerfectNumber1(int num,int sum) {
        for(int i=num/2;i>=2;i--){
            if(num%i == 0){
                sum = sum + i;
                System.out.print(i+"-");
                checkPerfectNumber1(i,sum);
                break;
            }
        }
        return sum;
    }
}
