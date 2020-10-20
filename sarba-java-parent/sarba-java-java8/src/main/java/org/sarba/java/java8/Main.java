package org.sarba.java.java8;

import org.sarba.java.java8.entity.Apple;
import org.sarba.java.java8.impl.Predicate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Apple> list = new ArrayList<Apple>();
        for (int i = 0 ; i < 1; i++){
            list.add(new Apple("red",234));
            list.add(new Apple("green",21));
            list.add(new Apple("green",123));
            list.add(new Apple("green",234));
            list.add(new Apple("red",21));
        }
        long start = System.currentTimeMillis();
        List<Apple> heavApples = list.parallelStream().filter((Apple a) -> a.getWeight() > 150).collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println("time :" + (end - start));
        List<Apple> greenList = list.stream().filter((Apple a) -> a.getWeight() > 150).collect(Collectors.toList());

        long a = System.currentTimeMillis();
        System.out.println("time a :" + (a - end));

        list.sort(Comparator.comparing(Apple::getWeight));
        print(list);

    }

    private static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> predicate){
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : apples) {
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    private static  void print(List<Apple> list){
        for (Apple apple : list) {
            System.out.println(apple.getWeight());
        }
    }

}
