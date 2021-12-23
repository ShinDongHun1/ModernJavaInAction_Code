package chapter2.attempt1;

import chapter2.Apple;

import java.util.ArrayList;
import java.util.List;

import static chapter2.Color.GREEN;

//== 1 번째 시도 : 녹색 사과 필터링 ==//
public class FilteringGreenApple {
    //Color에는  RED와 GREEN이 존재

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (GREEN == apple.getColor()) { //초록 사과만 필터링 가능. 그럼 빨간 사과를 필터링 하고 싶다면?
                result.add(apple);
            }
        }
        return result;
    }
}
