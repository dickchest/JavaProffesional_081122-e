package homework.extraHomeworkProfCourse.profBookApp.console;

import homework.extraHomeworkProfCourse.profBookApp.dto.requests.AddBookRequest;
import homework.extraHomeworkProfCourse.profBookApp.dto.responses.AddBookResponse;
import homework.extraHomeworkProfCourse.profBookApp.core.services.AddBookService;
import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class AddBookUIAction implements UIAction {

    private AddBookService service;

    @Override
    public void execute() {
        // запросите все данные о книге с консоли у пользователя
        // создайте экземпляр класса Book (не указывая поле id, его присвоит сама база данных)
        // сохраните его в базу данных: bookDatabase.save(book);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book Title");
        String title = scanner.nextLine();

        System.out.println("Enter book Author");
        String author = scanner.nextLine();

        System.out.println("Enter book Year");
        String year = scanner.nextLine();

//        AddXXXUIAction должен создавать AddXXXRequest, заполнять его
//        полученными от пользователя данными и передать в
//        AddXXXService.execute() метод.
        AddBookRequest request = new AddBookRequest(title, author, year);

        AddBookResponse response = service.execute(request);

        if (response.hasErrors()) {
            response.getErrors().stream().forEach(System.out::println);
        } else {
            System.out.println("Book with id " + response.getBook().getId() + " was added");
        }
    }

    @Override
    public String getActionName() {
        return "Add Book";
    }
}
