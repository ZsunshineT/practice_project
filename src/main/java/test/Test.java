package test;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * Description:
 * Created by zhangteng on 2020/10/27.
 */
public class Test {
    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            System.out.println(IdWorker.getId());
        }
    }
}
