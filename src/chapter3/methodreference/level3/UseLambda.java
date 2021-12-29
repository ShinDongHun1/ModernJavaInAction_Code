package chapter3.methodreference.level3;

import chapter2.Apple;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.*;

public class UseLambda {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        inventory.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));

        //Comparator<Apple> c = Comparator.comparing(a -> a.getWeight());


        //inventory.sort(Comparator.comparing(apple -> apple.getWeight()));
        inventory.sort(comparing(apple -> apple.getWeight()));//import static java.util.Comparator.*;


    }
}
