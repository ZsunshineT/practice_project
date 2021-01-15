package questions;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import freemarker.template.utility.StringUtil;

import java.util.Arrays;

/**
 * Description:
 * Created by zhangteng on 2021/1/15.
 */
public class PrefixesDivBy5 {
    public static void main(String[] args) {
        int[] param1 = {0,1,1,1,1,1};
        int[] param = {1,1,1,1,1,0};
        prefixesDivBy5(param);
    }

    private static boolean[] prefixesDivBy5(int[] param) {
        boolean[] result = new boolean[param.length];
        boolean flag = false;
        int j = 0;
        for(int i = 0;i<param.length;i++){
            if(!flag){
                if(param[i]!=0 ){
                    j = i;
                    flag = true;
                }else{
                    result[i] = false;
                }
            }else{
                int[] temp = Arrays.copyOfRange(param,j, i);
                int num = twoTten(temp);
                if(num%5 == 0){
                    result[i] = true;
                }
            }
        }
        return result;
    }
    private static int twoTten(int[] param) {
        int total = 0;
        for(int i=0;i<param.length;i++){
            total = (int) (total + param[i]*Math.pow(2,param.length-1-i));
        }
        System.out.println(total);
        return total;
    }
}
