package questions;

/**
 * Description:
 * Created by zhangteng on 2020/12/31.
 */
public class Reverse {
    public static void main(String[] args) {
        int num = 2147483647;
        int num1= 1234567896;
        int num2= 10;
        System.out.println(reverse(num2));
    }

    private static int reverse(int num) {
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();
        if(num<0){
            for(int i=1;i<=(chars.length/2);i++){
                char temp;
                temp = chars[i];
                chars[i] = chars[str.length()-i];
                chars[str.length()-i] = temp;
            }
            chars[0]='-';
            System.out.println(String.valueOf(chars));
        }else{
            for(int i=0;i<(chars.length/2);i++){
                char temp;
                temp = chars[i];
                chars[i] = chars[str.length()-1-i];
                chars[str.length()-1-i] = temp;
            }
            System.out.println(String.valueOf(chars));
        }
        long tempResult = Long.parseLong(String.valueOf(chars));
        if(tempResult>Integer.MAX_VALUE || tempResult<Integer.MIN_VALUE){
            return 0;
        }
        return Integer.parseInt(String.valueOf(chars));
    }

}
