package javaProfessionalCourse2.lesson20_Exceptions.Exceptions;

public class ProductValidationException extends RuntimeException {
    public ProductValidationException(String message) {
        super(message);
    }
}
