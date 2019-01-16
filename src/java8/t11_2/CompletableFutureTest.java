package java8.t11_2;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

public class CompletableFutureTest {

    public static void delay() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Double calculatePrice() {
        delay();
        Random random = new Random();
        return random.nextDouble();
    }

    public Double getPrice() {
        return calculatePrice();
    }

    public Future<Double> getPriceAsync() {
//        CompletableFuture<Double> future = new CompletableFuture<>();
//        new Thread(() -> {
//            try {
//                Double price = calculatePrice();
////                int i = 1 / 0;
//                future.complete(price);
//            } catch (Exception e) {
//                future.completeExceptionally(e);
//            }
//        }).start();
//        return future;
//        return CompletableFuture.supplyAsync(this::calculatePrice);
        return CompletableFuture.supplyAsync(() -> {
            Double price = calculatePrice();
            int i = 1 / 0;
            return price;
        });
    }

    @Test
    public void completableFutureTest() throws InterruptedException, ExecutionException {
        Double price = getPrice();
        System.out.println("getPrice");
        System.out.println(price);
        Future<Double> priceAsync = getPriceAsync();
        System.out.println("getPriceAsync");
        System.out.println(priceAsync.get());
    }

}
