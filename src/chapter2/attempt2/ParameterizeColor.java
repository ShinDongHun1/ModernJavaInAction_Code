package chapter2.attempt2;

import chapter2.Apple;
import chapter2.Color;

import java.util.ArrayList;
import java.util.List;

//== 두 번째 시도 : 색을 파라미터화 ==//
public class ParameterizeColor {

    public static List<Apple> filterColorApple(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getColor() == color) {//여기서 무게를 추가로 필터링 하고 싶다면?
                result.add(apple);
            }
        }
        return result;
    }
}
