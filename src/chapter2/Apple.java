package chapter2;

import chapter2.attempt1.Color;

public class Apple implements Comparable<Apple>{

    private Color color;

    private int weight;

    public int getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public int compareTo(Apple apple) {
        return this.weight-apple.getWeight();
    }
}
