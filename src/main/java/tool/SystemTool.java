package tool;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Description:
 * Created by zhangteng on 2020/10/27.
 */
public class SystemTool {
    public static String getUsedRate() {
        // 获取总空间
        Runtime runtime = Runtime.getRuntime();
        // 获取JVM总空间
        long total = runtime.totalMemory();
        // 获取JVM空闲空间
        long free = runtime.freeMemory();
        // 当前使用空间
        long usedMemory = total - free;
        // 获取当前使用率
        double useRate = 1.0*100*usedMemory/total;
        /* BigDecimal：有效位的数进行精确的运算
         * MathContext(指定的精度, 舍入模式)：根据上下文设置进行舍入
         * RoundingMode：指定丢弃精度的数值运算的舍入行为
         */
        BigDecimal bDecimal = new BigDecimal(useRate, new MathContext(3, RoundingMode.HALF_UP));
        return "内存使用率：" + bDecimal + "%";
    }
}
