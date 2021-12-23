package chapter2.attempt4;

import chapter2.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate{

    private int weight;

    public AppleHeavyWeightPredicate(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > weight;
    }
}
