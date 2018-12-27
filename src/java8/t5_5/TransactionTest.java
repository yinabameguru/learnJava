package java8.t5_5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class TransactionTest {

    private Trader raoul = new Trader("Raoul", "Cambridge");
    private Trader mario = new Trader("Mario", "Milan");
    private Trader alan = new Trader("Alan", "Cambridge");
    private Trader brian = new Trader("Brian", "Cambridge");
    private List<Transaction> transactions = Arrays.asList(
        new Transaction(brian, 2011, 300),
        new Transaction(raoul, 2012, 1000),
        new Transaction(raoul, 2011, 400),
        new Transaction(mario, 2012, 710),
        new Transaction(mario, 2012, 700),
        new Transaction(alan, 2012, 950)
    );

    @Test
    public void transactionTest() {
        List<Transaction> t1 = transactions.stream()
            .filter(transaction -> transaction.getYear() == 2011).sorted(Comparator
                .comparing(Transaction::getValue)).collect(Collectors.toList());
        System.out.println(t1.toString());
        List<Trader> t3 = transactions.stream().map(Transaction::getTrader)
            .filter(trader -> trader.getCity().equals("Cambridge")).distinct()
            .sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        System.out.println(t3.toString());
        List<String> t4 = transactions.stream().map(Transaction::getTrader)
            .map(Trader::getName).distinct().sorted().collect(Collectors.toList());
        System.out.println(t4);
        transactions.stream()
            .filter(transaction -> transaction.getTrader().getCity().equals("Milan")).findAny()
            .ifPresent(System.out::println);
        transactions.stream()
            .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
            .map(Transaction::getValue).reduce(Integer::sum).ifPresent(System.out::println);
        transactions.stream().map(Transaction::getValue).reduce(Integer::max)
            .ifPresent(System.out::println);
        transactions.stream().reduce(
            (transaction, transaction2) -> transaction.getValue() < transaction2.getValue()
                ? transaction : transaction2).ifPresent(System.out::println);
    }

}
