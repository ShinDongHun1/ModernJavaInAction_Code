package chapter3.lambdacapturing;

public class LambdaCapturing {


    public static void main(String[] args) {

        int a =1;//지역변수
        Runnable runnable = () -> System.out.println(a); //가능

        int b =1;//지역변수
        //Runnable runnable2 = () -> System.out.println(b++); //불가능

        int c =1;//지역변수
        //Runnable runnable3 = () -> System.out.println(c); //불가능
        c++;

        Runnable runnable4 = () -> System.out.println(staticInt++); //(정적 변수는 자유롭게 캡쳐 가능)가능

    }

    int instanceInt = 5;
    static int staticInt=5;
    public void test(){
        Runnable runnable = () -> System.out.println(staticInt++); //(정적 변수는 자유롭게 캡쳐 가능)가능
        Runnable runnable1 = () -> System.out.println(instanceInt++); //(인스턴스 변수는 자유롭게 캡쳐 가능)가능
    }
}
