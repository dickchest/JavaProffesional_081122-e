package javaProfessionalCourse2.lesson28.reentrantReadWriteLock;

public class ShopMain {
    public static void main(String[] args) {
        Shop shop = new Shop();

//        new ProducerThread(shop).start();
        new ConsumerThread(shop).start();



    }

    public static class ProducerThread extends Thread {
        private Shop shop;

        public ProducerThread(Shop shop) {
            this.shop = shop;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000; i++) {
                try {
                    Thread.sleep((long) Math.random() * 5_000);
                    shop.setGood(new Shop.Good(String.valueOf(i)));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static class ConsumerThread extends Thread{
        private Shop shop;

        public ConsumerThread(Shop shop) {
            this.shop = shop;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1_000_000; i++) {
                try {
                    Thread.sleep((long) Math.random() * 5000);
                    shop.getGood();
                    System.out.println("Осталось " + shop.getNumberOfGoods() + " товаров");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
