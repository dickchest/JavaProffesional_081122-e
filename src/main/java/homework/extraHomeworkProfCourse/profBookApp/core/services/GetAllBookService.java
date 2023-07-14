package homework.extraHomeworkProfCourse.profBookApp.core.services;

import homework.extraHomeworkProfCourse.profBookApp.dto.requests.GetAllBooksRequest;
import homework.extraHomeworkProfCourse.profBookApp.dto.responses.GetAllBooksResponse;
import homework.extraHomeworkProfCourse.profBookApp.repository.BookDatabase;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAllBookService {
    BookDatabase bookDatabase;
    public GetAllBooksResponse execute(GetAllBooksRequest request){
        return new GetAllBooksResponse(bookDatabase.getBooks());
    }
}
