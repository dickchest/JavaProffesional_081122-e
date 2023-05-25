package javaProfessionalCourse2.lesson25.synchronisedExample;

public class BankAccount {
    private int balance;
    public void increaseBalance() {
        balance = balance + 1000;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
