package homework.extraHomeworkProfCourse.profBookApp.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddBookRequest {
    private String title;
    private String author;
    private String year;
}
