package chapter5.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Result {


    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
                );


        List<Transaction> result1 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .toList();

        List<String> result2 = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .toList();

        List<Trader> result3 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getCity))
                .toList();


        String result4 = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted(Comparator.naturalOrder())
                .reduce( (n1, n2) -> n1 + "," + n2).orElse(null);

        boolean result5 = transactions.stream()
                .anyMatch(t -> t.getTrader().getCity().equals("Milan"));


        //== 6번 ==//
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);


        Integer result7 = transactions.stream().map(Transaction::getValue).reduce(Integer::max).orElse(null);

        Integer result8 = transactions.stream().map(Transaction::getValue).min(Comparator.naturalOrder()).orElse(null);

    }
}





class Transaction{
    private Trader trader;
    private int year;
    private int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }


    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}

class Trader{

    private String name;
    private String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
