package chapter3.usefunctionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UsePredicate {



    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if(p.test(t)) result.add(t);
        }
        return result;
    }

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        Predicate<String> stringFilter = (String s) -> !s.isEmpty();

        List<String> notEmptyStrings = filter(strings, stringFilter);
    }
}
