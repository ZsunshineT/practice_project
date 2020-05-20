package function;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * Description:
 * Created by zhangteng on 2020/5/20.
 */
public class FunctionTest {
    public static void main(String[] args) {
        test1();
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


}
