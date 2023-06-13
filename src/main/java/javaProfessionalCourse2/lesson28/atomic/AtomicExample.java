package javaProfessionalCourse2.lesson28.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicExample {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);

        // в потокобезопасной среде
        int newValue = counter.incrementAndGet();
        System.out.println("Новое значение: " + newValue);

        AtomicLong timestamp = new AtomicLong(0);

        // в потокобезопасной среде
        long newTimestamp = timestamp.incrementAndGet();
        System.out.println("Новый отметка времени: " + newTimestamp);

        AtomicReference<String> message = new AtomicReference<>("Привет");

        // в потокобезопасной среде
        String oldValue = message.getAndSet("Привет, мир!");
        System.out.println("Старое значение: " + oldValue);
    }
}
