package function;

import java.util.function.Function;

/**
 * Description:
 * Created by zhangteng on 2020/5/22.
 */
public interface Calculate extends Function<Integer,Integer> {

    Boolean showResult(Integer i);
}
