package chapter5.quiz;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class No2 {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Integer> integers1 = Arrays.asList(3, 4);
        List<Integer> integers2 = Arrays.asList(3, 4);

        List<Stream<int[]>> streams = integers.stream()
                .flatMap(
                        i ->
                                integers1.stream()
                                        .map(j -> integers2.stream().map(k -> new int[]{i, j, k}))
                )
                .toList();


    }
}
