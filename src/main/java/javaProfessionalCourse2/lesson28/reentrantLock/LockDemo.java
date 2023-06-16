package javaProfessionalCourse2.lesson28.reentrantLock;

public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(0);

        for (int i = 0; i < 5; i++) {
            new DepositThread(account).start();
        }

        account.waitAndWithdraw(50_000_000);

        System.out.println("waitAndWithdraw finished, end balance = " + account.getBalance());
    }

    private static class DepositThread extends Thread {
        private final Account account;

        public DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 60_000_000; i++) {
                account.deposit(1);
            }
        }
    }
}
