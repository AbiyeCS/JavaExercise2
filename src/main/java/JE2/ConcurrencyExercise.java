package JE2;

import java.util.concurrent.*;

public class ConcurrencyExercise {
    // TODO: Create a Runnable task that prints numbers 1–5 with a delay
    private static class printNumbers implements Runnable
    {

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Number: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO: Run two threads with the same task
        Thread t1 = new Thread(new printNumbers());
        t1.start();
        Thread t2 = new Thread(new printNumbers());
        t2.start();

        // TODO: Use ExecutorService with Callable to return a result (e.g. factorial of a number)
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            int num = 1;
            for (int i = 1; i <= 5; i++)
            {
                num *= i;
            }
            return num;
        };

        // Okay doesn't work as callable like this -> It only works as a runnable like this
        // executor.execute(task);

        // For it work as a callable I have to use a future
        Future<Integer> future = executor.submit(task);
        try{
            System.out.println("Result: " + future.get());
        }catch (Exception e){
            System.out.println(e);
        }
        executor.shutdown();


        // TODO: Use CompletableFuture to run async tasks and combine results
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            int num = 1;
            for (int i = 1; i <= 5; i++)
            {
                num *= i;
            }
            return num;
        }).thenApply(n -> n * 2);

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                return task.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<Integer> combined = future1.thenCombine(future2, (a,b) -> a + b);

        System.out.println("Sum = " + combined.join());
    }
}
