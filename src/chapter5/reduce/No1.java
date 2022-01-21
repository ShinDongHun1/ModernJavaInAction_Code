package chapter5.reduce;

import chapter4.level1.Dish;

import java.util.ArrayList;
import java.util.List;

public class No1 {

    public static void main(String[] args) {

        List<Dish> menu = new ArrayList<>();

        int count = menu.stream()
                .map(dish -> 1)
                .reduce(0, Integer::sum);

    }
}
