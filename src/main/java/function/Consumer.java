package function;

/**
 * Description:
 * Created by zhangteng on 2020/5/20.
 */
@FunctionalInterface
public interface Consumer {
    String buy(String name);
    // java.lang.Object中的方法不是抽象方法
    boolean equals(Object var1);
    //函数式接口里是可以包含默认方法，因为默认方法不是抽象方法，其有一个默认实现，所以是符合函数式接口的定义的
    default void defaultMethod(){
        System.out.println("defaultMethod");
    }
    //函数式接口里是可以包含静态方法，因为静态方法不能是抽象方法，是一个已经实现了的方法，所以是符合函数式接口的定义的
    static void staticMethod(){
        System.out.println("staticMethod");
    }
}
