package JavaProfessionalCourse2.Lesson20.Exceptions;

public class ProductValidationException extends RuntimeException {
    public ProductValidationException(String message) {
        super(message);
    }
}
