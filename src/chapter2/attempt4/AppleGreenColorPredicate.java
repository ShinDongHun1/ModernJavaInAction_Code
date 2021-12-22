package chapter2.attempt4;

import chapter2.Apple;

import static chapter2.attempt1.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
