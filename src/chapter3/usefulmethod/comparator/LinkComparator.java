package chapter3.usefulmethod.comparator;

import chapter2.Apple;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class LinkComparator {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        inventory.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor)
        );
    }
}
