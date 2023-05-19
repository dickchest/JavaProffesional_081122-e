package JavaProfessionalCourse2.Lesson23.multithredading;

/*
- либо наследуем от класса Thread и переопределить метод run()
- либо интерфейс Runnable переопределеяем метод run. Потом мы создаем экземпляр класса thread в который в качестве конструктора передаем наш класс

 */
public class MyFirstThread extends Thread {
    @Override
    public void run() {
        System.out.println("I'm Thread! My name is " + getName());
    }
}
