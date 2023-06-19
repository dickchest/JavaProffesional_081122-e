package javaProfessionalCourse2.lesson28.waitNotifyExtra;

public class AccountDemo {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(0);

        new DepositTread(account).start();

        System.out.println("Calling waitAndWithdraw() ...");

        account.waitAndWithdraw(50_000_000);

        System.out.println("waitAndWithdraw() finished");
    }

    private static class DepositTread extends Thread {
        private final Account account;

        private DepositTread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50_000_000; i++) {
                account.deposit(1);
            }
        }
    }
}
