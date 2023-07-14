package homework.extraHomeworkProfCourse.profBookApp.dto.responses;

import homework.extraHomeworkProfCourse.profBookApp.core.Book;
import homework.extraHomeworkProfCourse.profBookApp.core.validation.CoreError;
import homework.extraHomeworkProfCourse.profBookApp.core.validation.CoreResponse;

import lombok.Getter;

import java.util.List;


@Getter
public class AddBookResponse extends CoreResponse {
    Book book;

    public AddBookResponse(Book book) {
        this.book = book;
    }

    public AddBookResponse(List<CoreError> errors) {
        super(errors);
    }
}
