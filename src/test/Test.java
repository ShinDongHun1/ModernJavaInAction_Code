package test;

import java.util.Optional;

public class Test {


    public static void main(String[] args) {

        Optional<Integer> num = Optional.ofNullable(100);

        num.ifPresentOrElse(//num은 Optional<Integer>
                i -> save(i),
                () -> {
                    try {
                        nonSave();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        );

    }

    private static void save(Integer i) throws RuntimeException {
    }
    private static void nonSave() throws Exception {
    }
}
