package JE2.concurrency;

import java.util.concurrent.*;

public class ExecutorServiceExercise2 {
    public static void main(String[] args){
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<String> f1 = executor.submit(downloadSpeeds(8000, "File A"));
        Future<String> f2 = executor.submit(downloadSpeeds(15000, "File B"));
        Future<String> f3 = executor.submit(downloadSpeeds(10000, "File C"));

        try{
            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());
        }catch(InterruptedException e){
            System.out.println();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown(); // Always remember to shutdown Executor Service
        }
    }

    public static Callable<String> downloadSpeeds(int downloadTime, String fileName){
        return () -> {
          try{
              Thread.sleep(downloadTime);
          }catch (InterruptedException e){
              Thread.currentThread().interrupt();
              System.out.println("Interupted current thread: "+e);
          }
          return "File: "+fileName+" downloaded in "+downloadTime+" seconds";
        };
    }
}
