package chapter5.quiz;

import java.util.Arrays;
import java.util.List;

public class No1 {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> results = integers.stream()
                .map(i -> i * i)
                .toList();
    }
}
