package chapter2;

public class Apple implements Comparable<Apple>{

    private Color color;

    private Integer weight;

    public Integer getWeight() {
        return weight;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public int compareTo(Apple o) {
        return weight - o.getWeight();
    }
}
