package JavaProfessionalCourse2.Lesson19.Generics.Generics4;

public class OnlyNumber<T extends Number> {
    private T number;

    private double result;

    public OnlyNumber(T number) {
        this.number = number;
    }

    public void print() {
        System.out.println(number);
        System.out.println(result);
    }

    // 1. можно вынести этот метод за пределы класса. Использует только для хранения данных
    // 2. четко указать что результат дабл
    public void getResult() {
        result = number.doubleValue() * number.doubleValue();
    }
}
