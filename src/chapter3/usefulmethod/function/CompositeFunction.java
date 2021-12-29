package chapter3.usefulmethod.function;


import java.util.function.Function;

public class CompositeFunction {

    public static void main(String[] args) {

        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g); //g(f(x))
        int result = h.apply(1); //4를 반환

        Function<Integer, Integer> h2 = f.compose(g); //f(g(x))
        result = h2.apply(1); //3을 반환


    }
}
