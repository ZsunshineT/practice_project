package function;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Description:
 * Created by zhangteng on 2020/5/20.
 */
public class FunctionTest {
    public static void main(String[] args) {
        //test1();
        test4();
    }
    public static void test1(){
        //之前实现方法
        Consumer c = new Consumer() {
            @Override
            public String buy(String name) {
                System.out.println("买的"+name);
                return name;
            }
        };

        Consumer c1 = (name) -> {
            System.out.println("买的"+name);
            return name;
        };
        c1.buy("apple");
    }
    public static void test2(){
        Function<Integer, Integer> name = e -> e * 2;
        Function<Integer, Integer> square = e -> e * e;
        int value = name.andThen(square).apply(3);
        System.out.println("andThen value=" + value);
        int value2 = name.compose(square).apply(3);
        System.out.println("compose value2=" + value2);
        //返回一个执行了apply()方法之后只会返回输入参数的函数对象
        Object identity = Function.identity().apply("huohuo");
        System.out.println(identity);
    }

    public static void test3(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Predicate<Integer> predicate = n -> true
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // n 如果存在则 test 方法返回 true

        System.out.println("输出所有数据:");

        // 传递参数 n
        eval(list, n->true);

        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n%2 为 0 test 方法返回 true

        System.out.println("输出所有偶数:");
        eval(list, n-> n%2 == 0 );

        // Predicate<Integer> predicate2 = n -> n > 3
        // n 是一个参数传递到 Predicate 接口的 test 方法
        // 如果 n 大于 3 test 方法返回 true

        System.out.println("输出大于 3 的所有数字:");
        eval(list, n-> n > 3 );
    }
    public static void eval(List<Integer> list, Show<Integer> show) {
        for(Integer n: list) {
            if(show.show(n)) {
                System.out.println(n + " ");
            }
        }
    }
    public static void test4() {
        Function<Integer,Integer> test1=i->i+1;
        Function<Integer,Integer> test2=i->i*i;
        System.out.println(test1.andThen(test2).apply(3));
        System.out.println(test1.compose(test2).apply(3));
    }



}
