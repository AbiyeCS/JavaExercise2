package JE2.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExercise {
    public static void main(String[]args){

        List<String> words = Arrays.asList("John", "Bob", "Charlie", "Abz", "Tan");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<Integer> f1 = executor.submit(noOfChar(words.get(0),500));
        Future<Integer> f2 = executor.submit(noOfChar(words.get(1),500));
        Future<Integer> f3 = executor.submit(noOfChar(words.get(2),500));
        Future<Integer> f4 = executor.submit(noOfChar(words.get(3),500));
        Future<Integer> f5 = executor.submit(noOfChar(words.get(4),500));

        try{
            int results = f1.get() + f2.get() + f3.get() + f4.get() + f5.get();
            System.out.println("Results: "+ results);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Interrupted while waiting: " + e);
        } catch (ExecutionException e) {
            System.out.println("Task failed: " + e.getCause());
        } finally {
            executor.shutdown();
        }
    }

    private static Callable<Integer> noOfChar(String word, int delayMs){
        return () -> {
            int noOfChars = word.length();
            try {
                Thread.sleep(delayMs);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw e;
            }
            return noOfChars;
        };
    }
}
