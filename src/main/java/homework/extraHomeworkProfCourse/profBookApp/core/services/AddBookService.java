package homework.extraHomeworkProfCourse.profBookApp.core.services;


import homework.extraHomeworkProfCourse.profBookApp.core.Book;
import homework.extraHomeworkProfCourse.profBookApp.core.validation.AddBookServiceValidator;
import homework.extraHomeworkProfCourse.profBookApp.core.validation.CoreError;
import homework.extraHomeworkProfCourse.profBookApp.dto.requests.AddBookRequest;
import homework.extraHomeworkProfCourse.profBookApp.dto.responses.AddBookResponse;
import homework.extraHomeworkProfCourse.profBookApp.repository.BookDatabase;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AddBookService {
    BookDatabase bookDatabase;

    public AddBookResponse execute(AddBookRequest request) {
//        Добавьте в класс AddBookService логику валидации входных данных: параметров bookTitle и bookAuthor.
//        Оба параметра являются обязательными, не должны быть null или пустой строкой. В случае нарушения этих правил
//        должна выдаваться соответствующая ошибка и добавление объекта в базу данных не должно происходить.

        AddBookServiceValidator validator = new AddBookServiceValidator();
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) return new AddBookResponse(errors);

        Book book = new Book(request.getTitle(), request.getAuthor(), request.getYear());
        AddBookResponse response = new AddBookResponse(book);
        bookDatabase.save(book);
        return response;
    }
}
