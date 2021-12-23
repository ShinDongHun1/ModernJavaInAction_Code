package chapter2.practicalexample.example1;

import chapter2.Color;

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
    public int compareTo(Apple o) {
        return this.getWeight() - o.getWeight();
    }
}
