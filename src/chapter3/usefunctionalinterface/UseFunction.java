package chapter3.usefunctionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class UseFunction {


    public static <T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();

        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }


    public static void main(String[] args) {

        List<Integer> stringLength = map(
                Arrays.asList("modern" , "java", "in", "action"),

                //(String s) -> s.length()
                (s) -> s.length()
        );

    }

}
