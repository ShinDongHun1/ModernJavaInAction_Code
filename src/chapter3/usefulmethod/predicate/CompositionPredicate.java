package chapter3.usefulmethod.predicate;

import chapter2.Apple;

import java.util.function.Predicate;

public class CompositionPredicate {
    public static void main(String[] args) {



        //== 빨간색이 아닌 사과 ==//
        Predicate<Apple> redApple = (Apple a) -> a.getColor().equals("RED");
        Predicate<Apple> notRedApple = redApple.negate();


        //== 빨간색이면서 무거운 사과 ==//
        Predicate<Apple> redAndHeavyApple = redApple.and(apple -> apple.getWeight()>150);


        //== 빨간색이면서 무거운 사과 혹은 녹색 사과 ==//
        Predicate<Apple> redAndHeavyAppleOrGreen = redApple.and(apple -> apple.getWeight() > 150)
                .or(apple -> apple.getColor().equals("GREEN"));


    }
}
