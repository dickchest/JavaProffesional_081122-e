package homework.extraHomeworkProfCourse.profBookApp.console;

import homework.extraHomeworkProfCourse.profBookApp.dto.requests.GetAllBooksRequest;
import homework.extraHomeworkProfCourse.profBookApp.dto.responses.GetAllBooksResponse;
import homework.extraHomeworkProfCourse.profBookApp.core.services.GetAllBookService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAllBooksUIAction implements UIAction {
GetAllBookService service;
    @Override
    public void execute() {
        GetAllBooksRequest request = new GetAllBooksRequest();
        GetAllBooksResponse response = service.execute(request);
        System.out.println(response.getBooks());
    }

    @Override
    public String getActionName() {
        return "Print All Books";
    }
}
