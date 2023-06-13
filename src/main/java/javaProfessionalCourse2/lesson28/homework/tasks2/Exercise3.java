package javaProfessionalCourse2.lesson28.homework.tasks2;

import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;

/*
Дана коллекция объектов типа Car, имеющие
три параметра: название модели, год выпуска, цена.
Реализовать сортировку коллекции по каждому параметру.
Сортировку по одному из параметров провести в отдельном
потоке (т.е. каждый вид сортировки должен запускаться в отдельном потоке).
 */
public class Exercise3 {

    /**
    не могу понять, почему программа не выводит отсортированные списки
     */
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.addAll(List.of(
                new Car("Mercedes", 1988, 1200.00),
                new Car("Toyota", 2010, 8000.00),
                new Car("BMW", 2015, 15000.00),
                new Car("Ford", 2005, 5000.00),
                new Car("Honda", 2018, 10000.00)
        ));

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

        executorService.submit(() -> {
            Collections.sort(cars, Comparator.comparing(Car::getName));
            return "Sort by model: " + cars;
        });

        executorService.submit(() -> {
            Collections.sort(cars, Comparator.comparing(Car::getProductionYear));
            return "Sort by year: " + cars;
        });

        executorService.submit(() -> {
            Collections.sort(cars, Comparator.comparing(Car::getPrice));
            return "Sort by price: " + cars;
        });

        executorService.shutdown();

        // ждем окончания работы всех потоков
        try {
            for (int i = 0; i < 3; i++) {
                Future<String> future = completionService.take();
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(cars);
    }

    static class Car {
        String name;
        int productionYear;
        double price;

        public Car(String name, int productionYear, double price) {
            this.name = name;
            this.productionYear = productionYear;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getProductionYear() {
            return productionYear;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    ", productionYear=" + productionYear +
                    ", price=" + price +
                    '}';
        }
    }
}
