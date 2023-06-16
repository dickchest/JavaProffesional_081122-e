package javaProfessionalCourse2.lesson28.reentrantReadWriteLock;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Shop {
    private BlockingQueue<Good> goods;

    public Shop() {
        goods = new LinkedBlockingQueue<>();
    }

    public Good getGood() throws InterruptedException {
        return goods.take();
    }

    public void setGood(Good good) throws InterruptedException {
        goods.put(good);
    }

    public int getNumberOfGoods() {
        return goods.size();
    }

    // ----------------
    protected static class Good {
        String name;

        public Good(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Good{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
