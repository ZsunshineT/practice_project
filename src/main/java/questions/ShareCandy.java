package questions;

import static java.lang.Math.max;

/**
 * Description:
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * URL：https://leetcode-cn.com/problems/candy/solution/fen-fa-tang-guo-by-leetcode-solution-f01p/
 * Created by zhangteng on 2020/12/24.
 */
public class ShareCandy {
    public static void main(String[] args) {
        int[] a = {1,0,2,4};
        int[] b = {0,1,2,5,4,2,6,7,1,2,3,6,4,3,2,1};
        ShareCandy sc = new ShareCandy();
        System.out.println(sc.calCandy2(b));
    }
    private int calCandy1(int[] ratings){
        int n = ratings.length;
        int ret = 1;
        int inc = 1, dec = 0, pre = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                dec = 0;
                pre = ratings[i] == ratings[i - 1] ? 1 : pre + 1;
                ret += pre;
                inc = pre;
            } else {
                dec++;
                if (dec == inc) {
                    dec++;
                }
                ret += dec;
                pre = 1;
            }
        }
        return ret;
    }
    private int calCandy2(int[] ratings){
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];
        int resultNum = 0;
        for(int i=0;i<n;i++){
            if(i>0 && ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1;
            }else{
                left[i] = 1;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(i<n-1 && ratings[i+1] < ratings[i]){
                right[i] = right[i+1] + 1;
            }else{
                right[i] = 1;
            }
        }
        for(int i=0;i<n;i++){
            result[i] = max(left[i],right[i]);
        }
        for(int i=0;i<result.length;i++){
            resultNum = resultNum + result[i];
            System.out.print("-"+result[i]);
        }
        return resultNum;
    }
}
