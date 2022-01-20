package chapter5.slicing;

import chapter4.level1.Dish;
import chapter4.level1.Type;

import java.util.Arrays;
import java.util.List;

import static chapter4.level1.Type.*;

public class Slicing {


    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, OTHER),
                new Dish("prawns", false, 300, FISH),
                new Dish("rice", true, 350, OTHER),
                new Dish("chicken", false, 400, MEAT),
                new Dish("french fries", true, 530, OTHER)
        );


        specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .toList();


        //== takeWhile ==//
        specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320)
                .toList();


        //== dropWhile ==//
        specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320)
                .toList();


        //== 스트림 축소 ==//
        specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .toList();


        //== 요소 건너뛰기 ==//
        specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .toList();



    }
}
