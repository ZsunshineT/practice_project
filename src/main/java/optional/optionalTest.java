package optional;

import entities.User;

import java.util.Optional;

/**
 * Description:
 * Created by zhangteng on 2020/5/19.
 */
public class optionalTest {
    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
//        Optional<User> emptyOpt = Optional.empty();
//        System.out.println(emptyOpt.get());

        User user = new User();
        user.setName("zhangsan");
        Optional<User> Opt1 = Optional.of(user);
        System.out.println(Opt1.get().toString());

        //user = null;
        Optional<User> Opt2 = Optional.ofNullable(user);
        System.out.println(Opt2.isPresent()?Opt2.get():null);

        //检查是否有值的另一个选择是 ifPresent() 方法。该方法除了执行检查，还接受一个Consumer(消费者) 参数，
        // 如果对象不是空的，就对执行传入的 Lambda 表达式
        user.setName("lishi");
        Optional<User> Opt3 = Optional.ofNullable(user);
        Opt3.ifPresent(u-> {u.setName("wangwu");u.setAge(12);});
        System.out.println(user);

    }
}
