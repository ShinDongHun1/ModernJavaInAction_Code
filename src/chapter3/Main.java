package chapter3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {


    public static String keyboardInput() throws IOException{
        try (BufferedReader br =new BufferedReader(new InputStreamReader(System.in))){
            return br.readLine();
        }
    }




    public static String bufferedReaderProcess(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br =new BufferedReader(new InputStreamReader(System.in))){
            return p.process(br);
        }
    }

    public static void process(Runnable r){
        r.run();
    }



    public static <T, R> List<R> map(List<T> list , Function<T, R> f){
        ArrayList<R> result = new ArrayList<>();
        int[] a=new int[2];

        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }


    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if(p.test(t)){
                result.add(t);
            }
        }
        return result;
    }



    public static <T> void customForEach(List<T> list, Consumer<T> consumer){
        for (T t : list) {
            consumer.accept(t);
        }
    }





    public static void main(String[] args) throws IOException {

        process(() -> System.out.println("This is awesome!!"));
        System.out.println(keyboardInput());


        bufferedReaderProcess((BufferedReader br) -> br.readLine());
        bufferedReaderProcess((BufferedReader br) -> br.readLine()+br.readLine());


        ArrayList<String> strings = new ArrayList<>();

        List<String> nonEmpty = filter(strings, (s) -> !s.isEmpty());

        customForEach(Arrays.asList(1,2,3,4,5), (Integer i) -> System.out.println(i));


        map(Arrays.asList("lambdas","in","action"),(String s) -> s.length());
        map(Arrays.asList("lambdas","in","action"),(s) -> s.length());


        int num =1;//지역 변수

        customForEach(Arrays.asList(1,2,3,4,5), (Integer i) -> System.out.println(i));
        customForEach(Arrays.asList(1,2,3,4,5), (Integer i) -> System.out.println(i + num + staticNum));
        //customForEach(Arrays.asList(1,2,3,4,5), (Integer i) -> System.out.println(i + num++ + staticNum));//불가
        customForEach(Arrays.asList(1,2,3,4,5), (Integer i) -> System.out.println(i + num + staticNum++));
        customForEach(Arrays.asList(1,2,3,4,5), (Integer i) -> {
            int j=0;
            System.out.println(i + num + staticNum++ + j);
            System.out.println(i + num + staticNum++ + j++);
        });


    }

    static int staticNum =1;//클래스 변수

}
