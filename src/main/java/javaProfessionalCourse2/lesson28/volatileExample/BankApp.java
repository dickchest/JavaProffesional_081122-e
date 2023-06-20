package javaProfessionalCourse2.lesson28.volatileExample;

import java.util.ArrayList;
import java.util.List;

public class BankApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Runnable depositRunnable = () -> {
            for (int i = 0; i < 1000; i++) {
                account.deposit(10);
            }
        };

        Runnable withdrawRunnable = () -> {
            for (int i = 0; i < 1000; i++) {
                account.withdraw(10);
            }
        };

        Thread depositThread = new Thread(depositRunnable);
        Thread withdrawThread = new Thread(withdrawRunnable);

        depositThread.start();
        withdrawThread.start();

        //почему разный баланс

        try {
            depositThread.join();
            withdrawThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + account.getBalance());
    }
}
