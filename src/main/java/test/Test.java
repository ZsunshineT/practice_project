package test;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;

/**
 * Description:
 * Created by zhangteng on 2020/10/27.
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.addUser("aaaa"));
        System.out.println(test.addUser("aaaa"));
    }

    public String addUser(String id) {
        // 非空判断(忽略)...
        // -------------- 幂等性调用（开始） --------------
        if (!IdempotentUtils.judge(id, this.getClass())) {
            return "执行失败";
        }
        // -------------- 幂等性调用（结束） --------------
        // 业务代码...
        System.out.println("添加用户ID:" + id);
        return "执行成功！";
    }


}
