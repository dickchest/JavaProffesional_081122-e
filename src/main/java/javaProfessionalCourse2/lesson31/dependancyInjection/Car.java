package javaProfessionalCourse2.lesson31.dependancyInjection;

public class Car {
    Carcas carcas;
    Transmission transmission;
    Engine engine;

    public Car(Carcas carcas, Transmission transmission, Engine engine) {
        this.carcas = carcas;
        this.transmission = transmission;
        this.engine = engine;
    }
}
