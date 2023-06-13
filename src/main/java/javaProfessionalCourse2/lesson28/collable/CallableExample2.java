package javaProfessionalCourse2.lesson28.collable;

import java.util.concurrent.*;

public class CallableExample2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<Integer> callableTask = () -> {
            int a = 5;
            int b = 3;
            Thread.sleep(2000);
            return a + b;
        };

        Future<Integer> future = executorService.submit(callableTask);

        System.out.println("Ждем результата...");

        // блокируем поток до получения результата
        int result = future.get();
        System.out.println("Результат: " + result);
        executorService.shutdown();
    }
}
