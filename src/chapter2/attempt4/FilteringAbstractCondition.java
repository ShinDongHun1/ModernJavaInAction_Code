package chapter2.attempt4;


import chapter2.Apple;
import chapter2.Color;

import java.util.ArrayList;
import java.util.List;

//== 4 번째 조건 : 추상적 조건으로 필터링 ==//
public class FilteringAbstractCondition {

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate){
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if(predicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();

        filterApples(inventory, new AppleColorPredicate(Color.RED));
        filterApples(inventory, new AppleHeavyWeightPredicate(200));
    }
}
