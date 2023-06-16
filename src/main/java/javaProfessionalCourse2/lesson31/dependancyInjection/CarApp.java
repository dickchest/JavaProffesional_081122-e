package javaProfessionalCourse2.lesson31.dependancyInjection;

public class CarApp {
    public static void main(String[] args) {
        Carcas carcas = new Carcas();
        Transmission transmission = new Transmission();
        EngineDisel engineDisel = new EngineDisel();

        Car ourCar = new Car(carcas, transmission, engineDisel);

        EngineElectric engineElectric = new EngineElectric();

        Car electricCar = new Car(carcas, transmission, engineElectric);
    }
}
