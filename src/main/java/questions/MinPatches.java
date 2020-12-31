package questions;

/**
 * Description:
 * 给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间
 * 内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。
 * 链接：https://leetcode-cn.com/problems/patching-array
 * Created by zhangteng on 2020/12/29.
 */
public class MinPatches {
    public static void main(String[] args) {
        int[] b = {1};
        int n =5;
        System.out.println(minPatches(b,n));;
    }

    public static int minPatches(int[] nums, int n) {
        //累加的总和
        long total = 0;
        //需要补充的数字个数
        int count = 0;
        //访问的数组下标索引
        int index = 0;
        while (total < n) {
            if (index < nums.length && nums[index] <= total + 1) {
                //如果数组能组成的数字范围是[1,total]，那么加上nums[index]
                //就变成了[1,total]U[nums[index],total+nums[index]]
                //结果就是[1,total+nums[index]]
                total += nums[index++];
            } else {
                //添加一个新数字，并且count加1
                total = total + (total + 1);
                count++;
            }
        }
        return count;
    }
}
