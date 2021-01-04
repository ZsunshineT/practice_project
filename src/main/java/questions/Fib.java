package questions;

/**
 * Description:
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * Created by zhangteng on 2021/1/4.
 */
public class Fib {
    public static void main(String[] args) {
        for(int num=0;num <= 10;num++){
            System.out.print(fib1(num)+"-");
        }

    }

    /**
     * 传统的递归（耗时）
     * @param num
     * @return
     */
    private static int fib(int num) {
        if(num == 0 || num == 1){
            return num;
        }
        if(num > 1){
            return fib(num-1)+fib(num-2);
        }
        return 0;
    }

    /**
     * 速度快
     * @param num
     * @return
     */
    private static int fib1(int num) {
        int[] array = new int[num+1];
        for(int i=0;i<num+1;i++){
            if(i == 0 || i == 1){
                 array[i] = i;
            }
            if(i > 1){
                array[i] = array[i-1]+array[i-2];
            }
        }
        return array[num];
    }

}
