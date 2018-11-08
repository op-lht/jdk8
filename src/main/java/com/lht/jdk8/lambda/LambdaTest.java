package com.lht.jdk8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class LambdaTest {

    @FunctionalInterface
    interface Predicate<T> {
        boolean test(T t);
    }

    /**
     * 执行Predicate判断
     *
     * @param age       年龄
     * @param predicate Predicate函数式接口
     * @return 返回布尔类型结果
     */
    private static boolean doPredicate(int age, Predicate<Integer> predicate) {
        return predicate.test(age);
    }

    /**
     * 消费型接口示例
     *
     * @param money    捐赠的钱数
     * @param consumer 消费者
     */
    private static void donation(Integer money, Consumer<Integer> consumer) {
        consumer.accept(money);
    }

    /**
     * 供给型接口示例
     *
     * @param num      数字
     * @param supplier 提供者
     * @return list列表
     */
    private static List<Integer> supply(Integer num, Supplier<Integer> supplier) {
        List<Integer> resultList = new ArrayList<>();
        for (int x = 0; x < num; x++) {
            resultList.add(supplier.get());
        }
        return resultList;
    }

    /**
     * 断言型接口示例
     *
     * @param fruit     水果列表
     * @param predicate 断言
     * @return list列表
     */
    private static List<String> filter(List<String> fruit, Predicate<String> predicate) {
        List<String> list = new ArrayList<>();
        for (String s : fruit) {
            if (predicate.test(s)) {
                list.add(s);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.forEach(System.out::println);
        Runnable r = () -> System.out.println("hhhh");
        System.out.println(r);
        Integer num = 20;
        boolean isAdult = doPredicate(num, x -> x >= 18);
        System.out.println(isAdult);
        Integer moneyNum = 1000;
        donation(moneyNum, money -> System.out.println("好心的麦乐迪为Blade捐赠了" + money + "元"));
        System.out.println("--------------------------------");
        int num2 = 10;
        List<Integer> supply = supply(num2, () -> (int) (Math.random() * 100));
        System.out.println(supply);
        System.out.println("----------------断言型接口示例----------------");
        List<String> fruit = Arrays.asList("香蕉", "哈密瓜", "榴莲", "火龙果", "水蜜桃");
        List<String> newFruit = filter(fruit, s -> s.length() == 2);
        System.out.println(newFruit);
        new TreeSet<String>();
    }
}
