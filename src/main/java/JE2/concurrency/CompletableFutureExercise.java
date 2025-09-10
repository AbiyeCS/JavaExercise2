package JE2.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExercise {
    public static void main (String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(3); // Seems Like I don't need this line for CF

        CompletableFuture<Integer> f1 =
                CompletableFuture.supplyAsync(() -> {
                    try {
                        return makeTask(10, 1000).call();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

        CompletableFuture<Integer> f2 =
                CompletableFuture.supplyAsync(() -> {
                    try {
                        return makeTask(20, 2000).call();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

        CompletableFuture<Integer> f3 =
                CompletableFuture.supplyAsync(() -> {
                    try {
                        return makeTask(30, 3000).call();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });

        CompletableFuture<Integer> combined = f1.thenCombine(f2, (a,b) -> a + b).thenCombine(f3, (c,d) -> c + d);
        System.out.println(combined.join());

    }
    public static Callable<Integer> makeTask(int value, int delayMs){
        return () -> {
          try {
              Thread.sleep(delayMs);
          }catch (InterruptedException e){
              Thread.currentThread().interrupt();
              throw e;
          }
          return value;
        };
    }
}
