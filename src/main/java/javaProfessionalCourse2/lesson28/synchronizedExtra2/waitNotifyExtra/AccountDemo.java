package javaProfessionalCourse2.lesson28.synchronizedExtra2.waitNotifyExtra;

public class AccountDemo {
    public static void main(String[] args) {
        Account account = new Account(100_000);
        System.out.println("Begin balance = " + account.getBalance());

        Thread withdrawTread = new WithdrawTread(account);
        Thread depositTread = new DepositTread(account);
        withdrawTread.start();
        depositTread.start();

        try {
            withdrawTread.join();
            depositTread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("End balacne = " + account.getBalance());
    }

    private static class WithdrawTread extends Thread {
        private final Account account;

        private WithdrawTread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20_000; i++) {
                account.withdraw(1);
            }
        }
    }

    private static class DepositTread extends Thread {
        private final Account account;

        private DepositTread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20_000; i++) {
                account.deposit(1);
            }
        }
    }
}
