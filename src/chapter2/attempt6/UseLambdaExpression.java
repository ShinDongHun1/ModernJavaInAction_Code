package chapter2.attempt6;

import chapter2.Apple;
import chapter2.Color;

import java.util.ArrayList;
import java.util.List;

//== 6번째 시도 : 람다 표현식 사용 ==//
public class UseLambdaExpression {

    public static List<Apple> filterApples(List<Apple> inventory, chapter2.attempt5.ApplePredicate predicate){
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
        filterApples(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
    }
}
