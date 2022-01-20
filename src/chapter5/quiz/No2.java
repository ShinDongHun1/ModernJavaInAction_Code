package chapter5.quiz;

import java.util.Arrays;
import java.util.List;

public class No2 {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Integer> integers1 = Arrays.asList(3, 4);

        List<int[]> result = integers.stream()
                .flatMap(
                        i ->
                                integers1.stream()
                                        .map(j -> new int[]{i, j})//Stream<int[]>를 반환
                )
                .toList();


    }
}
