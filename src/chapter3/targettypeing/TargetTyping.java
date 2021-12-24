package chapter3.targettypeing;

import java.security.PrivilegedAction;
import java.util.concurrent.Callable;

public class TargetTyping {

    public static void main(String[] args) {
        PrivilegedAction<Integer> integerPrivilegedAction = () -> 42;
        Callable<Integer> c = () -> 42;
    }
}
