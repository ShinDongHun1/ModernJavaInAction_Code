package chapter3.integrate;

import java.util.function.DoubleFunction;

public class Integrate {

    public static void main(String[] args) {

        integrate(f, 3, 7);


    }

    public static double integrate(DoubleFunction<Double> f, double a, double b){
        return (f.apply(a) + f.apply(b)) * ( b - a ) / 2.0;
    }
}
