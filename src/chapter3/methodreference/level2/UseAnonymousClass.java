package chapter3.methodreference.level2;

import chapter2.Apple;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UseAnonymousClass {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
    }
}
