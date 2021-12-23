package chapter2.attempt4;

import chapter2.Apple;
import chapter2.Color;

public class AppleColorPredicate implements ApplePredicate{

    private Color color;

    public AppleColorPredicate(Color color) {
        this.color = color;
    }

    @Override
    public boolean test(Apple apple) {
        return color.equals(apple.getColor());
    }
}
