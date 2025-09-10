package JE2.concurrency;

import java.util.concurrent.*;

/*
## More Practice Task

**Step 1: ExecutorService + Callable**

- Submit 3 tasks that each sleep for 1s and return numbers (e.g., 10, 20, 30).
- Collect the results with `future.get()` and sum them.

Going to do more ExecutorService task before moving on as didn't do great on the exercise
- See Notion for the additional Task

**Step 2: CompletableFuture**

- Do the same, but with `supplyAsync` for each number.
- Use `thenCombine` (or `allOf`) to add them up.
- Print the final sum without blocking individually on each future.

 */

public class ConcurrencyExercise2 {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // My attempt at step 1. Didn't go great
//        Callable<Integer> task = () -> {
//            int num = 0;
//            for (int i = 0; i <30;) {
//
//
//                i = i + 10;
//                Thread.sleep();
//            }
//
//            return num;
//        };
//
//        Future<Integer> future1 = executorService.submit(task);
//        Future<Integer> future2 = executorService.submit(task);
//        Future<Integer> future3 = executorService.submit(task);
//        try{
//            System.out.println("Result: " + future1.get());
//            System.out.println("Result: " + future2.get());
//            System.out.println("Result: " + future3.get());
//        }catch (Exception e){
//            System.out.println(e);
//        }

        // attempt 2 with help
        // helper to produce a callable with its own value & delay
        Future<Integer> f1 = executorService.submit(makeTask(10,1000));
        Future<Integer> f2 = executorService.submit(makeTask(20,1000));
        Future<Integer> f3 = executorService.submit(makeTask(30, 1000));

        try {
            int r1 = f1.get();
            int r2 = f2.get();
            int r3 = f3.get();
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Interrupted while waiting: " + e);
        } catch (ExecutionException e) {
            System.out.println("Task failed: " + e.getCause());
        } finally {
            executorService.shutdown();
        }
    }

    private static Callable<Integer> makeTask(int value, int delayMs){
        return () -> {
            try {
                Thread.sleep(delayMs);      // simulate work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // restore interrupt
                throw e; // or return a sentinel if you prefer
            }
            return value;
        };
    }
}
