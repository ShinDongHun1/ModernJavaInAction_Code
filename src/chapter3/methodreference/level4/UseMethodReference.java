package chapter3.methodreference.level4;

import chapter2.Apple;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparing;

public class UseMethodReference {

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        inventory.sort(comparing(Apple::getWeight));//import static java.util.Comparator.*;
    }
}
