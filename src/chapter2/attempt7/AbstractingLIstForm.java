package chapter2.attempt7;

import chapter2.Apple;
import chapter2.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//== 7번쩨 시도 : 리스트 형식으로 추상화 ==//
public class AbstractingLIstForm {

    //java.util.function의 Predicate<T> 사용

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();

        for (T t : list) {
            if(p.test(t)){
                result.add(t);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        filter(inventory, (Apple apple) -> Color.RED.equals(apple.getColor()));
    }

}
