package JavaProfessionalCourse2.Lesson23.multithredading;

public class Car extends Thread{
    private final String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        System.out.println("Car " + model + " is being driving by thread "+ Thread.currentThread().getName());
    }
}
