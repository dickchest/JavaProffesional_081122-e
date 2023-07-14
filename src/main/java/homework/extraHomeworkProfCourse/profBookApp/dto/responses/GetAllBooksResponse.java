package homework.extraHomeworkProfCourse.profBookApp.dto.responses;

import homework.extraHomeworkProfCourse.profBookApp.core.Book;
import homework.extraHomeworkProfCourse.profBookApp.core.validation.CoreResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/*
Создайте класс GetAllXXXResponse и добавьте в него список возвращаемых
объектов. Список возвращаемых объектов должен передаваться в
класс ответа через конструктор и сохраняться в соответствующем
свойстве класса. Так же создайте get метод для получения списка.
Set метод создавать не надо.
 */
@AllArgsConstructor
@Getter
public class GetAllBooksResponse extends CoreResponse {
    private List<Book> books;
}
