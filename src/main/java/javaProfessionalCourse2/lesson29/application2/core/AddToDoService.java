package javaProfessionalCourse2.lesson29.application2.core;

import javaProfessionalCourse2.lesson29.application2.core.validation.*;
import javaProfessionalCourse2.lesson29.application2.domain.ToDoEntity;
import javaProfessionalCourse2.lesson29.application2.dto.AddToDoRequest;
import javaProfessionalCourse2.lesson29.application2.dto.AddToDoResponse;
import javaProfessionalCourse2.lesson29.application2.repository.ToDoRepository;

import java.util.ArrayList;

public class AddToDoService {
    private ToDoRepository repository;

    public AddToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    ArrayList<ValidationRule> validationRuleList = new ArrayList<>();

    private ValidationService validationService = new ValidationService(validationRuleList);


    public AddToDoResponse add(AddToDoRequest request) {
        validationRuleList.add(new ToDoNameNullValidationRule());
        validationRuleList.add(new ToDoNameMinLengthValidationRule());
        validationRuleList.add(new ToDoNameMaxLengthValidationRule());
        validationRuleList.add(new ToDoDescriptionNullValidationRule());
        validationRuleList.add(new ToDoDescriptionNullValidationRule());

        System.out.println("Received request " + request);
        var validationResult = validationService.validate(request);
        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors: " + validationResult);
            var response = new AddToDoResponse();
            response.setErrors(validationResult);
            return response;
        }

        var entity = convert(request);
        var createdEntity = repository.save(entity);
        System.out.println("Successfully saved: " + createdEntity);
        var response = new AddToDoResponse();
        response.setCreatedToDoId(createdEntity.getId());
        System.out.println("Sending response: " + response);
        return response;
    }

    private ToDoEntity convert(AddToDoRequest request) {
        ToDoEntity entity = new ToDoEntity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        return entity;
    }

}
