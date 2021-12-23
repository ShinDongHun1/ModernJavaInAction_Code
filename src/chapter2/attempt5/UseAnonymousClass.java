package chapter2.attempt5;

import chapter2.Apple;
import chapter2.Color;

import java.util.ArrayList;
import java.util.List;

//== 5번째 시도 : 익명 클래스 사용 ==//
public class UseAnonymousClass {

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

        filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.getColor());
            }
        });

    }
}
