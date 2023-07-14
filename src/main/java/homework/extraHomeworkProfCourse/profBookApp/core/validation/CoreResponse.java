package homework.extraHomeworkProfCourse.profBookApp.core.validation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public abstract class CoreResponse {
    private List<CoreError> errors = new ArrayList<>();

    public boolean hasErrors() {
//        Добавьте в класс CoreResponse метод
//        public boolean hasErrors()
//        и реализуйте его. Этот метод должен возвращать true тогда когда
//        в списке есть ошибки, иначе false.
        return errors == null || errors.isEmpty() ? false : true;

    }
}
