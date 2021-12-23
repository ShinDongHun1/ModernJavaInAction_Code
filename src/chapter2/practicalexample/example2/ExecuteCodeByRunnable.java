package chapter2.practicalexample.example2;

//== 실전 예제 2 : Runnable로 코드 블록 실행하기 ==//
public class ExecuteCodeByRunnable {

    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Modern Java In Action");
            }
        });

        Thread t2 = new Thread(() -> System.out.println("Modern Java In Action"));

        Thread t3 = new Thread(() -> {
            System.out.println("Modern Java In Action");
            System.out.println("Modern Java In Action");
        });

    }
}
