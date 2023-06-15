package javaProfessionalCourse2.lesson29.application2.core.validation;

import javaProfessionalCourse2.lesson29.application2.dto.AddToDoRequest;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ValidationService {
    private final List<ValidationRule> validationRules;

    public ValidationService(List<ValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public List<CoreError> validate(AddToDoRequest request) { // возвращаем список ошибок, которые могут быть в запросе
        List<CoreError> errors = new ArrayList<>();
        if (request == null) {
            errors.add(new CoreError("ToDo must not be null"));
            return errors;
        }

        return validationRules.stream()
                .map(rule -> validate(rule, request))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private CoreError validate(ValidationRule rule, AddToDoRequest request) {
        try {
            rule.validate(request);
        } catch (ValidationException e) {
            return new CoreError(e.getMessage());
        }
        return null;
    }
}
