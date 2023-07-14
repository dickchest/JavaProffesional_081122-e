package homework.extraHomeworkProfCourse.profBookApp.core.validation;

import javaProfessionalCourse2.lesson20_Exceptions.String.StringTimeTest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CoreError {
    private String field;
    private String message;

    @Override
    public String toString() {
        return "Error: " + field + " - " + message;
    }
}
