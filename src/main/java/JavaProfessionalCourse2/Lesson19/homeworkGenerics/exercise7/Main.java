package JavaProfessionalCourse2.Lesson19.homeworkGenerics.exercise7;


/*
7)  Создайте класс Optional для представления значения, которое может
    отсутствовать. Реализуйте методы isPresent(), get() и orElse().
    Используйте Generics для возможности хранения в Optional объектов
    разных типов.
 */
public class Main {

    public static void main(String[] args) {
        Optional<String> opt = new Optional<>("1");
        System.out.println(opt.isPresent());
        System.out.println(opt.orElse("empty"));
        System.out.println(opt.getObject());

        System.out.println("----------------");

        Optional<String> opt1 = new Optional<>();
        System.out.println(opt1.isPresent());
        System.out.println(opt1.orElse("empty"));
        System.out.println(opt1.getObject());
    }

}
