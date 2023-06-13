package javaProfessionalCourse2.lesson28.homework.tasks1;

import java.util.concurrent.Semaphore;

/*
2. Создать три потока, каждый из которых выводит определенную букву(A, B и C) 5 раз,
порядок должен быть именно ABСABСABС. Используйте wait/notify/notifyAll.
 */
public class Exercise2 {
    private static final Object monitor = new Object();
    private static volatile char currentChar = 'A';
    private static volatile int count = 0;

    public static void main(String[] args) {

//        semaphore();
        Thread threadA = new Thread(new letterOut('A'));
        Thread threadB = new Thread(new letterOut('B'));
        Thread threadC = new Thread(new letterOut('C'));
//
        threadA.start();
        threadB.start();
        threadC.start();

    }

    public static void semaphore() {
        Semaphore semaphoreA = new Semaphore(1);
        Semaphore semaphoreB = new Semaphore(0);
        Semaphore semaphoreC = new Semaphore(0);

        Thread threadA = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    semaphoreA.acquire();
                    System.out.print("A");
                    semaphoreB.release();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    semaphoreB.acquire();
                    System.out.print("B");
                    semaphoreC.release();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    semaphoreC.acquire();
                    System.out.print("C");
                    semaphoreA.release();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }

    static class letterOut implements Runnable {
        private char treadCharacter;

        public letterOut(char treadCharacter) {
            this.treadCharacter = treadCharacter;
        }


        @Override
        public void run() {
            try {
                synchronized (monitor) {
                    while (count < 5) {
                        while (treadCharacter != currentChar) {
                            monitor.wait();
                        }
                        System.out.println(treadCharacter);

                        if (currentChar == 'C') {
                            currentChar = 'A';
                            count++;
                        } else {
                            currentChar++;
                        }
                        monitor.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


