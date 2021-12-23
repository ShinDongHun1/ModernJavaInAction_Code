package chapter2.practicalexample.example3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//== 실전 예제 3 : Callable을 결과로 반환하다. ==//
public class ReturnResultByCallable {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName();
            }
        });


        Future<String> threadName = executorService.submit(() -> Thread.currentThread().getName());
    }
}
