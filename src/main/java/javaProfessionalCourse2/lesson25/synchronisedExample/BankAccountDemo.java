package javaProfessionalCourse2.lesson25.synchronisedExample;

import javaProfessionalCourse2.lesson19_generic_optional.Generics.Generics4.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BankAccountDemo {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();

        BankAccount bankAccount = new BankAccount();

        for (int i = 0; i < 1000; i++) {
            bankAccount.setBalance(0);

            TestThread thread1 = new TestThread(bankAccount);
            TestThread thread2 = new TestThread(bankAccount);

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            list.add(bankAccount.getBalance());

        }
            System.out.println(list);
    }
}
