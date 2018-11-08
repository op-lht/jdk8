package com.lht.jdk8.jdk8_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterApple {

    //策略模式
    public static interface AppleFilter<Apple> {
        boolean filter(Apple t);
    }

    public static List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if (appleFilter.filter(apple)) {
                list.add(apple);
            }
        }
        return list;
    }

    private static List<Apple> findGreenApple(List<Apple> apples) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                list.add(apple);
            }
        }
        return list;
    }

    public static List<Apple> findApple(List<Apple> apples, String color) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                list.add(apple);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(
                new Apple("green", 500),
                new Apple("green", 570),
                new Apple("red", 560),
                new Apple("yellow", 540)
        );
//        List<Apple> greenApples = findGreenApple(list);
//        //断言
//        assert greenApples.size() == 0 : "错误了 list中没有值";
//        System.out.println(greenApples);
//        List<Apple> apples = findApple(list, "red");
//        System.out.println(apples);
        List<Apple> result = findApple(list, new AppleFilter() {
            @Override
            public boolean filter(Object t) {
                return false;
            }
        });
        System.out.println(result);
    }
}
