package chapter5.searchandmatching;

import chapter4.level1.Dish;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exam {
    public static void main(String[] args) {
        List<Dish> menu = new ArrayList<>();

        if(menu.stream().anyMatch(Dish::isVegetarian)){
            System.out.println("The menu is vegetarian friendly");
        }

        //boolean isHealthy = menu.stream().anyMatch(dish -> dish.getCalories() < 1000);
        boolean isHealthy = menu.stream().noneMatch(dish -> dish.getCalories() >= 1000);


        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();


        List<Integer> someNumbers = Arrays.asList(1,2,3,4,5);

        Optional<Integer> firstSquareDivisibleByThree = someNumbers.stream()
                .map(num -> num * num)
                .filter(num -> num % 3 == 0)
                .findFirst();
    }
}
