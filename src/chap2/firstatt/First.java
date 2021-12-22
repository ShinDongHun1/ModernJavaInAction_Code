package chap2.firstatt;

import chap2.Apple;

import java.util.ArrayList;
import java.util.List;

import static chap2.firstatt.Color.GREEN;
import static chap2.firstatt.Color.RED;

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



    //== 네 번째 시도 -> 동적 파라미터화 사용. ==//

    /**
     * 참 또는 거짓을 반환하는 함수를 프레디케이트라고 한다.
     * 선택 조건을 정의하는 인터페이스를 정의하자.
     */
    public interface ApplePredicate{
        boolean test(Apple apple);
    }

    public class AppleHeavyWeightPredicate implements ApplePredicate{
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }
    public class AppleGreenColorPredicate implements ApplePredicate{
        @Override
        public boolean test(Apple apple) {
            return GREEN.equals(apple.getColor());
        }
    }
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate applePredicate) {//전략 패턴
        ArrayList<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if(applePredicate.test(apple)){
                result.add(apple);
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

    }
}
