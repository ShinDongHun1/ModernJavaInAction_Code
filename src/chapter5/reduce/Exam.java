package chapter5.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Exam {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,45,5,676,7,324,34,1234);

        int sum = 0;
        for(int x : numbers){
            sum += x;
        }


        numbers.stream().reduce(0, (a,b) -> a + b);
        numbers.stream().reduce(1, (a,b) -> a * b);

        numbers.stream().reduce(0, Integer::sum);

        Optional<Integer> optSum = numbers.stream().reduce(Integer::sum);


        //== 최댓값 ==//
        numbers.stream().reduce(Integer::max);

        //== 최솟값 ==//
        numbers.stream().reduce(Integer::min);
    }
}
