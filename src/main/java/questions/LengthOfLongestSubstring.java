package questions;

/**
 * Description:
 * Created by zhangteng on 2021/1/5.
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String str = "abcsdd";
        lengthOfLongestSubstring(str);
    }
    public static int lengthOfLongestSubstring(String str) {
        char[] chars = str.toCharArray();
        int result = 0;
        for(int i = 0;i < chars.length;i++){
            for(int j=i+1;j < chars.length;j++){
                if(chars[i] == chars[j]){
                    if(result < j-i){
                        result = j-i;
                    }
                }
            }
        }
        return result;
    }
}
