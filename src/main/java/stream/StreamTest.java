package stream;

import com.sun.deploy.util.StringUtils;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import entities.Vehicle;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Description:
 * Created by zhangteng on 2020/5/20.
 */
public class StreamTest {
    static List<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        test3();
    }
    public static void test1(){
        //遍历列表
        vehicles.forEach(vehicle -> System.out.println(vehicle));
        vehicles.forEach(System.out::println);

        //遍历map
        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);map.put("b",2);map.put("c",3);
        map.forEach((k,v) -> System.out.println("key:"+k+",value:"+v));

        //去掉评分为3分以下的车
        List<Vehicle> collect = vehicles.stream().filter(vehicle -> vehicle.getScore() >= 3).collect(Collectors.toList());

        //对一个 List<Object> 大部分情况下，我们只需要列表中的某一列，或者需要把里面的每一个对象转换成其它的对象，这时候可以使用 map 映射
        List<String> vins = vehicles.stream().map(Vehicle::getVin).collect(Collectors.toList());
        vins.forEach(vin-> System.out.println(vin));

        // 按照公司 Id 进行分组
        Map<Integer, List<Vehicle>> companyVehicles = vehicles.stream().collect(Collectors.groupingBy(Vehicle::getCompanyId));
       // 按照公司分组求司机打分和
        Map<Integer, Double> collectSums = vehicles.stream().collect(Collectors.groupingBy(Vehicle::getCompanyId, Collectors.summingDouble(Vehicle::getScore)));
        collectSums.forEach((k,v)-> System.out.println("key:"+k+";value:"+v));

        // 单列排序
        vehicles.sort((v1,v2) -> v2.getScore().compareTo(v1.getScore()));
        // 或使用 Comparator 类来构建比较器，流处理不会改变原列表，需要接收返回值才能得到预期结果
        List<Vehicle> collect1 = vehicles.stream().sorted(Comparator.comparing(Vehicle::getScore).reversed()).collect(Collectors.toList());
        // 多列排序，score 降序，companyId 升序排列
        List<Vehicle> collect2= vehicles.stream().sorted(Comparator.comparing(Vehicle::getScore).reversed()
                .thenComparing(Comparator.comparing(Vehicle::getCompanyId)))
                .collect(Collectors.toList());
        collect1.forEach(v-> System.out.println(v));

        // 对所有司机的总分求和
        Double reduce = vehicles.stream().parallel().map(Vehicle::getScore).reduce(1d, Double::sum);
        System.out.println(reduce);

    }

    public static void init(){
        List<String> imeis = new ArrayList<>();
        for (int i = 0; i <5 ; i ++  ) {
            List<String> singleVehicleDevices = new ArrayList<>();
            for (int j = 0; j < 3; j++ ) {
                imeis.add(i+","+j);
            }
        }
        vehicles.add(new Vehicle("KPTSOA1K67P081452","17620411498","9420",1,4.5,imeis.get(0)));
        vehicles.add(new Vehicle("KPTCOB1K18P057071","15073030945","张玲",2,1.4,imeis.get(1)));
        vehicles.add(new Vehicle("KPTS0A1K87P080237","19645871598","sanri1993",1,3.0,imeis.get(2)));
        vehicles.add(new Vehicle("KNAJC526975740490","15879146974","李种",1,3.9,imeis.get(3)));
        vehicles.add(new Vehicle("KNAJC521395884849","13520184976","袁绍",2,4.9,imeis.get(4)));
    }

    public static void test2(){
        Map<String, String> grades = new HashMap(){
            {
                put("1", "A");
                put("2", "B");
                put("3", "A");
                put("4", "C");
                put("5", "A");
                put("6", "B");
            }
        };
        Map<String, List<String>> stat = grades.entrySet().stream().collect(Collectors.groupingBy(
                Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        System.out.println(stat);
    }
    public static void test3(){
        //forEach
        Random random = new Random();
        random.ints().limit(3).forEach(System.out::println);
        // map获取对应的平方数
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squaresList = numbers.stream().map( i -> i*i).collect(Collectors.toList());
        System.out.println(squaresList);
        //filter获取空字符串的数量
        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println(count);
        //limit打印前3个数据
        List<String> strings1 = strings.stream().limit(3).collect(Collectors.toList());
        System.out.println(strings1);

    }


}
