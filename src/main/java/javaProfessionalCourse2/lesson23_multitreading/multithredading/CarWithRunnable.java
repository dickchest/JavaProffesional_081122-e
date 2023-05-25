package javaProfessionalCourse2.lesson23_multitreading.multithredading;

public class CarWithRunnable implements Runnable{
    private final String model;

    public CarWithRunnable(String model) {
        this.model = model;
    }

    @Override
    public void run() {
        try{
            System.out.println("Start! " + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println("Car " + model + " is being driving by thread "+ Thread.currentThread().getName());
    }
}
