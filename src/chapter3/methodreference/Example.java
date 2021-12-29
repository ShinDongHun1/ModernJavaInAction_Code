package chapter3.methodreference;

import chapter2.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import static java.util.Comparator.*;

public class Example {

    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();


        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));

        inventory.sort(comparing(Apple::getWeight));//Comparator static import




        Function<Apple, Integer> appleIntegerFunction = (Apple a) -> a.getWeight();
        Function<Apple, Integer> appleIntegerFunctionByReference = Apple::getWeight;

        BiFunction<String, Integer, String> stringIntegerStringBiFunction = (String str, Integer i) -> str.substring(i);
        BiFunction<String, Integer, String> stringIntegerStringBiFunctionByReference = String::substring;

        Consumer<String> stringConsumer = (String s) -> System.out.println(s);
        Consumer<String> stringConsumerReference = System.out::println;


    }
}
