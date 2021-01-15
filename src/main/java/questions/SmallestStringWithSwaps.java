package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Created by zhangteng on 2021/1/11.
 */
public class SmallestStringWithSwaps {
    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> pair1 = new ArrayList<>();
        pair1.add(0);pair1.add(3);
        List<Integer> pair2 = new ArrayList<>();
        pair2.add(1);pair2.add(2);
        List<Integer> pair3 = new ArrayList<>();
        pair3.add(0);pair3.add(2);
        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);
        System.out.println(smallestStringWithSwaps(s,pairs));
    }

    private static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] chars = s.toCharArray();
        for(int i =0;i<pairs.size();i++){
            char temp = 0;
            int begin = pairs.get(i).get(0);
            int end = pairs.get(i).get(1);
            temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] =temp;
        }
        String result = String.valueOf(chars);
        return result;
    }
}
