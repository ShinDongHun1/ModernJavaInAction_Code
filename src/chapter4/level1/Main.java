package chapter4.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Dish> menu = new ArrayList<>();
        List<Dish> lowCaloricDishes = new ArrayList<>();

        for(Dish dish : menu){
            if(dish.getCalories() < 400){
                lowCaloricDishes.add(dish);
            }
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }


        List<String> streamLowCaloricDishesName = menu.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .toList();


        List<String> parallelStreamLowCaloricDishesName = menu.parallelStream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .toList();


        List<String> threeHighCaloricDishNames =
                menu.stream()// 메뉴(요리 리스트)에서 스트림을 얻는다
                        .filter(dish -> dish.getCalories() > 300)//파이프라인 연산 만들기, 첫 번째로 고칼로리 요리를 필터링한다
                        .map(Dish::getName) //요리명을 추출한다
                        .limit(3)//선착순 3개만 선택한다
                        .toList();//결과를 다른 리스트로 저장한다.

    }
}
