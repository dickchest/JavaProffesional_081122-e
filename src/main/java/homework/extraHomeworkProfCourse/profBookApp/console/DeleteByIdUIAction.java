package homework.extraHomeworkProfCourse.profBookApp.console;

import homework.extraHomeworkProfCourse.profBookApp.dto.requests.RemoveBookRequest;
import homework.extraHomeworkProfCourse.profBookApp.dto.responses.RemoveBookResponse;
import homework.extraHomeworkProfCourse.profBookApp.core.services.RemoveBookService;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class DeleteByIdUIAction implements UIAction {
    private RemoveBookService service;

    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book id:");
        Long id = scanner.nextLong();

//        RemoveXXXUIAction должен создавать RemoveXXXRequest, заполнять его
//        полученными от пользователя данными и передать в
//        RemoveXXXService.execute() метод.
        RemoveBookRequest request = new RemoveBookRequest(id);
        RemoveBookResponse response = service.execute(request);
        if (response.hasErrors()) {
            response.getErrors().stream().forEach(System.out::println);
        } else {
            System.out.println("Book deleting status: " + response.isDeleted());
        }
    }

    @Override
    public String getActionName() {
        return "Delete By ID";
    }
}
