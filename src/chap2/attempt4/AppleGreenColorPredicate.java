package chap2.attempt4;

import chap2.Apple;

import static chap2.attempt1.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
