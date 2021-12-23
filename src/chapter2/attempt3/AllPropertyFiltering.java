package chapter2.attempt3;

import chapter2.Apple;
import chapter2.Color;

import java.util.ArrayList;
import java.util.List;

//== 세 번째 시도 : 가능한 모든 속성으로 필터링 ==//
public class AllPropertyFiltering {

    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if ( (flag && apple.getColor().equals(color) )|| (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Apple> inventory = new ArrayList<>();

        //== 뭘 하는건지 알 수 없는 코드이다.. ==//
        filterApples(inventory, Color.GREEN, 0, true);
        filterApples(inventory, null, 150, false);
    }
}
