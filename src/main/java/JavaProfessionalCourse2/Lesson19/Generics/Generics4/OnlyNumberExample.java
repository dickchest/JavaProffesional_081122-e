package JavaProfessionalCourse2.Lesson19.Generics.Generics4;

public class OnlyNumberExample {
    public static void main(String[] args) {
        OnlyNumber<Integer> number1 = new OnlyNumber<>(1);
        OnlyNumber<Long> number2 = new OnlyNumber<>(123L);
        OnlyNumber<Double> number3 = new OnlyNumber<>(1.1);

//        OnlyNumber<String> number4 = new OnlyNumber<>("1");


    }
}
