package homework.extraHomeworkProfCourse.profBookApp.dto.responses;

import homework.extraHomeworkProfCourse.profBookApp.core.Book;
import homework.extraHomeworkProfCourse.profBookApp.core.validation.CoreError;
import homework.extraHomeworkProfCourse.profBookApp.core.validation.CoreResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


public class RemoveBookResponse extends CoreResponse {
    private boolean isDeleted;

    public RemoveBookResponse(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public RemoveBookResponse(List<CoreError> errors) {
        super(errors);
    }

    public boolean isDeleted() {
        return isDeleted;
    }
}
