package chap2.attempt1;

import chap2.Apple;
import chap2.attempt4.AppleGreenColorPredicate;
import chap2.attempt4.AppleHeavyWeightPredicate;
import chap2.attempt4.ApplePredicate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Predicate;

import static chap2.attempt1.Color.GREEN;
import static chap2.attempt1.Color.RED;

public class First {

    //== 첫 번째 시도 - > 녹색 사과 필터링 ==//
    public static List<Apple> filterGreenApple(List<Apple> inventory) {
        ArrayList<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    //== 첫 번째 시도 종료 ==//


    //== 두 번째 시도 -> 색을 파라미터화 ==//
    public static List<Apple> filterAppleByColor(List<Apple> inventory, Color color){
        ArrayList<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }


    public static List<Apple> filterAppleByWeight(List<Apple> inventory, int weight){
        ArrayList<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }
    //== 두 번째 시도 끝 ==//


    //== 세 번째 시도 -> 가능한 모든 속성으로 필터링 ==//

    /**
     * 실전에서는 절대 이 방법을 사용하지 말아라
     */

    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {//flag가 대체 뭔데;;
        ArrayList<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)){
                result.add(apple);
            }
        }
        return result;
    }
    //== 세 번째 시도 종료 ==//



    //== 네 번째 시도 -> 동작 파라미터화 ==//
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate applePredicate) {//전략 패턴
        ArrayList<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if(applePredicate.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
    //== 네 번째 시도 끝 ==//




    //== 일곱 번째 시도 -> 리스트 형식으로 추상화 ==//
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        ArrayList<T> result = new ArrayList<>();

        for (T e : list) {
            if(p.test(e)){
                result.add(e);
            }
        }
        return result;
    }






    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        List<Apple> greenApples = filterAppleByColor(inventory, GREEN);
        List<Apple> redApples = filterAppleByColor(inventory, RED);


        //== 세 번째 시도 -> 정말 별로인 메서드 ==//
        filterApples(inventory, GREEN, 0, true);
        filterApples(inventory, null, 150, false);

        //== 네 번째 시도 ==//
        filterApples(inventory, new AppleGreenColorPredicate());
        filterApples(inventory, new AppleHeavyWeightPredicate());



        //== 다섯 번째 시도 시작, 익명 클래스 사용 ==//
        /**
         * 너무 많은 공간을 차지
         */
        filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return RED.equals(apple.getColor());
            }
        });


        //== 여섯 번째 시도 람다 표현식 사용 ==//
        filterApples(inventory, (Apple apple) -> RED.equals(apple.getColor()));


        //== 일곱 번째 시도 -> 리스트 형식으로 추상화 사용 ==//
        filter(inventory, (Apple apple) -> RED.equals(apple.getColor()));
        ArrayList<Integer> numbers = new ArrayList<>();
        filter(numbers, (Integer number) -> number % 2 == 0);




        //== 실전 예제 1 - Comparator로 정렬하기 ==//

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.compareTo(o2);
            }
        });

        inventory.sort((Apple o1, Apple o2) -> o1.compareTo(o2));


        //== 실전 예제 2 - Runnable로 코드 블록 실행하기 ==//
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Modern Java In Action!!");
            }
        });

        Thread t2 = new Thread(() -> System.out.println("Modern Java In Action"));


        //== 실전 예제 3 - Callable을 결과로 반환하기 ==//
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> threadName = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });

        Future<String> threadName2 = executorService.submit(() -> Thread.currentThread().getName());






    }
}
