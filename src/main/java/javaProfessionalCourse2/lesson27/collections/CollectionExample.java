package javaProfessionalCourse2.lesson27.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public class CollectionExample {
    public static void main(String[] args) {
        int numberOfThreads = 100;
        int numberOfElements = 1_000_000;

        List<Integer> myArrayList = new ArrayList<>();
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();


        List<Thread> concurrentList = new ArrayList<>();
        // рзаделяем задачи
        for (int i = 0; i < numberOfThreads; i++) {
            Thread thread = new Thread(() -> {
                synchronized (myArrayList) {
                    for (int j = 0; j < numberOfElements; j++) {
                        myArrayList.add(j);
                    }
                }
            });
            concurrentList.add(thread);
        }

        long startTime = System.currentTimeMillis();
        for (Thread thread : concurrentList) {
            thread.start();
        }
        for (Thread thread : concurrentList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        long endTime = System.currentTimeMillis();

        long myArrayListTime = endTime - startTime;

        System.out.println("Time array list = " + myArrayListTime);

    }
}
