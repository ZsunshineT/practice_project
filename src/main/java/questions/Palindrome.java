package questions;

/**
 * Description:
 * Created by zhangteng on 2020/12/31.
 */
public class Palindrome {
    public static void main(String[] args) {
        int num = 121;
        System.out.println(isPalindrome(num));
    }

    private static boolean isPalindrome(int num) {
        String str = String.valueOf(num);
        boolean flag =true;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                flag = false;
                break;
            }
        }
        return flag;
    }

}
