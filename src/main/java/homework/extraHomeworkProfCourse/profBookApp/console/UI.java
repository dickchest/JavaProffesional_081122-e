package homework.extraHomeworkProfCourse.profBookApp.console;

import homework.extraHomeworkProfCourse.profBookApp.repository.BookDatabase;
import homework.extraHomeworkProfCourse.profBookApp.repository.BookDatabaseImpl;
import homework.extraHomeworkProfCourse.profBookApp.core.services.AddBookService;
import homework.extraHomeworkProfCourse.profBookApp.core.services.GetAllBookService;
import homework.extraHomeworkProfCourse.profBookApp.core.services.RemoveBookService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UI {
    private Map<Integer, UIAction> menuNumberToActionMap;

    public UI() {
        BookDatabase bookDatabase = new BookDatabaseImpl();
        AddBookService addBookService = new AddBookService(bookDatabase);
        GetAllBookService getAllBookService = new GetAllBookService(bookDatabase);
        RemoveBookService removeBookService = new RemoveBookService(bookDatabase);


        menuNumberToActionMap = new HashMap<>();
        menuNumberToActionMap.put(1, new AddBookUIAction(addBookService));
        menuNumberToActionMap.put(2, new FindByIdUIAction(bookDatabase));
        menuNumberToActionMap.put(3, new FindByAuthorUIAction(bookDatabase));
        menuNumberToActionMap.put(4, new FindByTitleUIAction(bookDatabase));
        menuNumberToActionMap.put(5, new DeleteByIdUIAction(removeBookService));
        menuNumberToActionMap.put(6, new DeleteByAuthor(bookDatabase));
        menuNumberToActionMap.put(7, new DeleteByTitle(bookDatabase));
        menuNumberToActionMap.put(8, new CountAllBooksUIAction(bookDatabase));
        menuNumberToActionMap.put(9, new GetAllBooksUIAction(getAllBookService));
        menuNumberToActionMap.put(10, new GetAuthorToBooksMap(bookDatabase));
        menuNumberToActionMap.put(11, new GetEachAuthorBookCount(bookDatabase));
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        while (true) {
            printMenu();
            if (getMenuResponse(sc)) break;
        }
    }

    private boolean getMenuResponse(Scanner sc) {
        int userSelectedMenuNumber = Integer.parseInt(sc.nextLine());
        if (userSelectedMenuNumber == 0) {
            System.out.println("Thank you! Good by!");
            return true;
        } else {
            executeUIAction(userSelectedMenuNumber);
        }
        return false;
    }

    private void printMenu() {
        menuNumberToActionMap.entrySet().forEach(x -> System.out.println(x.getKey() + " - " + x.getValue().getActionName()));
        System.out.println("PLease enter menu number: ");
    }

    private void executeUIAction(int userSelectedMenuNumber) {
        UIAction uiAction = menuNumberToActionMap.get(userSelectedMenuNumber);
        if(uiAction!= null) {
            uiAction.execute();;
        } else {
            System.out.println("Menu item not exist: " + userSelectedMenuNumber);
        }
    }
}
