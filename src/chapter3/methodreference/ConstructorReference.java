package chapter3.methodreference;


import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReference {

    public static void main(String[] args) {

        //== 기본 생성자 ==//
        Supplier<Apple> c1 = Apple::new;
        Apple apple = c1.get(); //Supplier의 get 메서드를 호출해서 새로운 Apple 객체를 만들 수 있다.
        //위 코드와 아래 코드는 같다
        Supplier<Apple> c2= () -> new Apple();
        Apple apple2 = c2.get();

        //== 매개변수가 1개인 생성자 ==//
        //2 Apple (Integer weight)라는 시그니처를 갖는 생성자의 경우
        Function<Integer, Apple> c3 = Apple::new;
        Apple apple3 = c3.apply(110); //weight가 110인 Apple 생성
        //위 코드와 아래 코드는 같다.
        Function<Integer, Apple> c4 = (weight) -> new Apple(weight);
        Apple apple4 = c3.apply(110); //weight가 110인 Apple 생성


        //== 매개변수가 2개인 생성자 ==//
        BiFunction<Integer, String, Apple> c5 = (weight, color) -> new Apple(weight, color);
        BiFunction<Integer, String, Apple> c6 = Apple::new;



        //== 매개변수가 3개인 생성자 => 일치하는 시그니처를 갖는 함수형 인터페이스가 없기 때문에 새로 만들어야 함 ==//
        TriFunction<Integer, String, Integer, Apple> c7 = (weight, color, price) -> new Apple(weight, color, price);
        TriFunction<Integer, String, Integer, Apple> c8 = Apple::new;
    }
}
class Apple{
    private Integer weight;
    private String color;
    private Integer price;

    public Apple(){
    }
    public Apple(Integer weight){
        this.weight = weight;
    }

    public Apple(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Apple(Integer weight, String color, Integer price) {
        this.weight = weight;
        this.color = color;
        this.price = price;
    }
}

interface TriFunction<T,U,V,R>{
    R apply(T t, U u, V v);
}
