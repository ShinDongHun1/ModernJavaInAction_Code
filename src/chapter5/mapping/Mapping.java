package chapter5.mapping;

import chapter4.level1.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Mapping {
    public static void main(String[] args) {


        List<Dish> menu = new ArrayList<>();

        //== 이름 추출 ==//
        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .toList();

        //== 이름 길이 추출 ==//
        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .toList();


        //== 고유문자 추출, 실패 ==//
        List<String> words = Arrays.asList("Hello", "World");

        words.stream()
                .map(word -> word.split(""))
                .distinct()
                .toList();

        //== 성공 ==//
        words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)//생성된 스트림을 하나의 스트림으로 평면화
                .distinct()
                .toList();


    }
}
