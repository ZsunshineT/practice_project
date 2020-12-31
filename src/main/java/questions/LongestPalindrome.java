package questions;

import java.util.Date;

/**
 * Description:给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * Created by zhangteng on 2020/12/30.
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String str = "lcnvoknqgejxbfhijmxglisfzjwbtvhodwummdqeggzfczmetrdnoetmcydwddmtubcqmdjwnpzdqcdhplxtezctvgnpobnnscrmeqkwgiedhzsvskrxwfyklynkplbgefjbyhlgmkkfpwngdkvwmbdskvagkcfsidrdgwgmnqjtdbtltzwxaokrvbxqqqhljszmefsyewwggylpugmdmemvcnlugipqdjnriythsanfdxpvbatsnatmlusspqizgknabhnqayeuzflkuysqyhfxojhfponsndytvjpbzlbfzjhmwoxcbwvhnvnzwmkhjxvuszgtqhctbqsxnasnhrusodeqmzrlcsrafghbqjpyklaaqximcjmpsxpzbyxqvpexytrhwhmrkuybtvqhwxdqhsnbecpfiudaqpzsvfaywvkhargputojdxonvlprzwvrjlmvqmrlftzbytqdusgeupuofhgonqoyffhmartpcbgybshllnjaapaixdbbljvjomdrrgfeqhwffcknmcqbhvulwiwmsxntropqzefwboozphjectnudtvzzlcmeruszqxvjgikcpfclnrayokxsqxpicfkvaerljmxchwcmxhtbwitsexfqowsflgzzeynuzhtzdaixhjtnielbablmckqzcccalpuyahwowqpcskjencokprybrpmpdnswslpunohafvminfolekdleusuaeiatdqsoatputmymqvxjqpikumgmxaxidlrlfmrhpkzmnxjtvdnopcgsiedvtfkltvplfcfflmwyqffktsmpezbxlnjegdlrcubwqvhxdammpkwkycrqtegepyxtohspeasrdtinjhbesilsvffnzznltsspjwuogdyzvanalohmzrywdwqqcukjceothydlgtocukc";
        Long a = new Date().getTime();
        System.out.println(longestPalindrome(str));
        Long b = new Date().getTime();
        System.out.println(b - a);
    }

    public static String longestPalindrome(String str) {
        int curNum = 0;
        int finalNum = 0;
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = finalNum + i; j <= str.length(); j++) {
                String subStr = str.substring(i, j);
                if (isPalindrome(subStr)) {
                    curNum = subStr.length();
                    if (finalNum < curNum) {
                        finalNum = curNum;
                        result = subStr;
                    }
                }
            }
        }
        return result;
    }

    public static boolean isPalindrome(String subStr) {
        boolean flag = true;
        for (int i = 0; i < subStr.length(); i++) {
            if (subStr.charAt(i) != subStr.charAt(subStr.length() - 1 - i)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
