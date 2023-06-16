package javaProfessionalCourse2.lesson28.executorsExtra;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println("Submit worker 1");
        Future<String> future1 = executor.submit(new Worker("Worker1"));

        System.out.println("Submit worker 2");
        Future<String> future2 = executor.submit(new Worker("Worker2"));

        System.out.println("Result from worker 1: " + future1.get());
        System.out.println("Result from worker 2: " + future2.get());

        System.out.println("-------------------");

        System.out.println("Submit workers using invokeAll()");
        List<Future<String>> futures = executor.invokeAll(
                Arrays.asList(new Worker("worker3"), new Worker("worker4"), new Worker("worker5")));

        System.out.println("Exited invokeAll()");
        for (Future<String> future : futures) {
            System.out.println("Result from worker: " + future.get());
        }

        executor.shutdown();
        executor.awaitTermination(10L, TimeUnit.SECONDS);
    }

    private static class Worker implements Callable<String> {
        private final String name;

        public Worker(String name) {
            this.name = name;
        }

        public String call() throws InterruptedException {
            long sleepTime = (long) (Math.random() * 10_000);
            System.out.println(name + " started, going to sleep for " + sleepTime + " milis");
            Thread.sleep(sleepTime);
            System.out.println(name + " finished");
            return name;
        }
    }
}
