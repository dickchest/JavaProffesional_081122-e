package JavaProfessionalCourse2.Lesson20.Exceptions;

public class TryCatchExample {
    public static void main(String[] args) {
        try {
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        validateProductName("1212344444444441234213412341324132413241324234123434");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("1");
        System.out.println("1");
        } catch (ProductValidationException e) {
            System.out.println("Validation failed, reason: "+ e.getMessage());
            e.printStackTrace();
            illegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally");
        }

        System.out.println("Program finished!");
    }

    static void illegalArgumentException() {
        throw new IllegalArgumentException("random error");
    }

    static void validateProductName(String name) {
        if (name.length() < 10) {
            throw new ProductValidationException("Product name should be greater then 10");
        }
        if (name.length() > 20) {
            throw new ProductValidationException("Product name should be less then 20");
        }
    }

}

