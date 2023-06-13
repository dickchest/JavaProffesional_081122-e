package javaProfessionalCourse2.lesson28.fromBook;

import javaProfessionalCourse2.lesson19_generic_optional.homeworkGenerics.exercise10.SortUtils;

public class MyThread implements Runnable {
    Thread thrd; // ссылка на поток храниться в этой переменной

    // Создание нового потока на основе интерфейса и
    // присвоение ему имени
    MyThread(String name) {
        thrd = new Thread(this, name); // имя потоку присваивается при его создании
    }

    // Создание и запуск потока с попощью фабричного метода
    public static MyThread createAndStart(String name) {
        MyThread myThrd = new MyThread(name);
        myThrd.thrd.start(); // запуск потока -Ю начало выполения потока
        return myThrd;
    }

    @Override
    // Точка входа для потока
    public void run() {
        System.out.println(thrd.getName() + " - запуск.");

        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("В " + thrd.getName() + ", счетчик: " + count);
            }
        } catch (InterruptedException e) {
            System.out.println(thrd.getName() + " - прерван.");
        }
        System.out.println(thrd.getName() + " - зевершен.");
    }
}

class ThreadVariations {
    public static void main(String[] args) {
        System.out.println("Запуск основного потока.");

        // Создание и запуск потока
        MyThread mt = MyThread.createAndStart("Порожденный поток №1");
        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Прерывание основного потока.");
            }
        }
        System.out.println("Завершение основного потока.");
    }
}
