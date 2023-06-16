package javaProfessionalCourse2.lesson28.forkJoingPool;

import java.util.Arrays;
import java.util.concurrent.atomic.DoubleAdder;

public class ParallelStreamNotBroken {

    public static void main(String[] args) {
        int[] array = Commons.prepareArray();

        long startTime = System.currentTimeMillis();

        DoubleAdder sum = new DoubleAdder();
        Arrays.stream(array)
                .parallel()
                .mapToDouble(Commons::function)
                .forEach(sum::add);

        long endTime = System.currentTimeMillis();

        System.out.println("sum = " + sum);
        System.out.println("time = " + (endTime - startTime) + " ms");
    }
}
