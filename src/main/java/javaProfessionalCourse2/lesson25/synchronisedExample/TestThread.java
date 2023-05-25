package javaProfessionalCourse2.lesson25.synchronisedExample;

public class TestThread extends Thread{
    BankAccount bankAccount;

    public TestThread(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        this.bankAccount.increaseBalance();
    }
}
