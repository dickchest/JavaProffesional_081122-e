package javaProfessionalCourse2.lesson28.volatileExample;

public class BankAccount {
    private volatile int balance = 0;

    public void deposit(int amount) {
        // сложная операция: чтение, измененеие и запись нового значения баланса
        balance += amount;
    }

    public void withdraw(int amount) {
        // сложная операция: чтение, измененеие и запись нового значения баланса
        balance -= amount;
    }

    public int getBalance() {return balance;}
}
