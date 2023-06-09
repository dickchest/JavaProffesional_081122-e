package javaProfessionalCourse2.lesson28.synchronizedExtra2.waitNotifyExtra;

public class Account {
    private long balance;

    public Account() {
        this(0L);
    }

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void deposit(long amount) {
        checkAmountNonNegative(amount);
        synchronized (this) {
            balance += amount;
        }
    }

    public void withdraw(long amount) {
        checkAmountNonNegative(amount);
        synchronized (this) {
            if (balance < amount) {
                throw new IllegalArgumentException("not enough memory");
            }
            balance -= amount;
        }

    }

    private static void checkAmountNonNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("negative amount");
        }
    }
}
