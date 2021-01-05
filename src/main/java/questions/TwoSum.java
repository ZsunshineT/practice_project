package questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Created by zhangteng on 2021/1/5.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] a = {1,2};
        twoSum(a,3);
        twoSum1(a,3);
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int temp = nums[i]+nums[j];
                if(temp==target){
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
    }
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
