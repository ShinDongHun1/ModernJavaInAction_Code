package chapter2.practicalexample.example1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//== 실전 예제 1 : Comparator로 정렬하기 ==//
public class SortByComparator {


    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();

        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.compareTo(o2);
            }
        });

        inventory.sort((o1, o2) -> o1.compareTo(o2));

    }
}
