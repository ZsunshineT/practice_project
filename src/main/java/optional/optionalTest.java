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

        //Optional 类提供了 API 用以返回对象值，或者在对象为空的时候返回默认值。
        //这里你可以使用的第一个方法是 orElse()，它的工作方式非常直接，如果有值则返回该值，否则返回传递给它的参数值
        user = null;
        User user2 = new User("tom", 13);
        User result1 = Optional.ofNullable(user).orElse(user2);
        System.out.println(result1);

        User user3 = new User("karry", 14);
        User result2 = Optional.ofNullable(user2).orElse(user3);
        System.out.println(result2);

        user = null;
        User result3 = Optional.ofNullable(user).orElse(createNewUser("null-orElse-createNewUser"));
        System.out.println(result3);
        User result4 = Optional.ofNullable(user).orElseGet(() -> createNewUser("null-orElseGet-createNewUser"));
        System.out.println(result4);

        User result5 = Optional.ofNullable(user3).orElse(createNewUser("notnull-orElse-createNewUser"));
        System.out.println(result5);
        User result6 = Optional.ofNullable(user3).orElseGet(() -> createNewUser("notnull-orElseGet-createNewUser"));
        System.out.println(result6);

        //有很多种方法可以转换 Optional  的值。我们从 map() 和 flatMap() 方法开始
        User user7 = new User(null, 123);
        String userName = Optional.ofNullable(user7).map(u -> u.getName()).orElse("new-jiangqi");
        System.out.println(userName);
        System.out.println(user7);

        //除了转换值之外，Optional  类也提供了按条件“过滤”值的方法。
        //filter() 接受一个 Predicate 参数，返回测试结果为 true 的值。如果测试结果为 false，会返回一个空的 Optional
        User user8 = new User("user8name", 34);
        Optional<User> user8opt = Optional.ofNullable(user8)
                .filter(u -> u.getName() != null);
        System.out.println(user8opt.get());
    }

    private static User createNewUser(String name) {
        return new User(name,23);
    }

}
