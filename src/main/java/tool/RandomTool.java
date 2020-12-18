package tool;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.UUID;

/**
 * Description:
 * Created by zhangteng on 2020/10/27.
 */
public class RandomTool {
    /**
     * 随机生成简体汉字
     * @param j
     * @return
     */
    public static String getRandomChar(int j) {
        String ret="";
        for(int i=0;i<j;i++){
            String str = null;
            int hightPos, lowPos; // 定义高低位
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39))); //获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); //获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try {
                str = new String(b, "GBK"); //转成中文
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            ret+=str;
        }
        return ret;
    }

    /**
     * 获取随机字符串
     * @param i（i<=32）
     * @return
     */
    public static String getRandomString(int i) {
        return UUID.randomUUID().toString().replaceAll("\\-", "").substring(0,i);
    }

    /**
     * 生成随机数字
     * @param i
     * @return
     */
    public static int getRandomNumber(int i) {
        //如果设置种子seed=1，则每次调用getRandomNumber生成的随机数都一样（参数i一样时）
        Random rand = new Random();
        String result="";
        if(i == 0){
            return 0;
        }
        result = get1To9Number()+"";
        for(int j = 0;j<i-1;j++){
            result = result + rand.nextInt(10);
        }
        return Integer.parseInt(result);
    }

    /**
     * 随机生成1-9数字
     * @return
     */
    public static int get1To9Number() {
        return (int)((Math.random()*9+1));
    }
    /**
     * 随机生成0-9数字
     * @return
     */
    public static int get0To9Number() {
        return (int)((Math.random()*10));
    }


}
