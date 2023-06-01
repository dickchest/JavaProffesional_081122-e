package javaProfessionalCourse2.lesson26.homeworkMyself;
/*
напоминалка по методу join - ожидание выполнения потока, на котором вызывается
 */
public class JoinEx {
    public static void main(String[] args) {
        Thread tr1 = new Thread(() -> {
            System.out.println("выполняю поток 1");
            try {
                Thread.sleep(3000);
                System.out.println("Поток 1 закончил выполнение");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread tr2 = new Thread(() -> {
            System.out.println("выполняю поток 2");
            try {
                tr1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Поток 2 закончил выполнение");
        });

        // запускаю потоки
        tr1.start();
        tr2.start();

        // ждем ожидания потоков
        try {
            tr1.join();
//            tr2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("the end");

    }
}
