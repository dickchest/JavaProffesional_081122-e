package homework.extraHomeworkProfCourse.bookLibraryApp.UI;

import homework.extraHomeworkProfCourse.bookLibraryApp.repository.BookDatabase;
import homework.extraHomeworkProfCourse.bookLibraryApp.repository.BookDatabaseImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BookLibrary {
    private Map<Integer, UIAction> menuNumberToActionMap;

    public BookLibrary() {
        BookDatabase bookDatabase = new BookDatabaseImpl();

        menuNumberToActionMap = new HashMap<>();
        menuNumberToActionMap.put(1, new SaveBookUIAction(bookDatabase));
        menuNumberToActionMap.put(2, new FindByIdUIAction(bookDatabase));
        menuNumberToActionMap.put(3, new FindByAuthorUIAction(bookDatabase));
        menuNumberToActionMap.put(4, new FindByTitleUIAction(bookDatabase));
        menuNumberToActionMap.put(5, new DeleteByIdUIAction(bookDatabase));
        menuNumberToActionMap.put(6, new DeleteByAuthor(bookDatabase));
        menuNumberToActionMap.put(7, new DeleteByTitle(bookDatabase));
        menuNumberToActionMap.put(8, new CountAllBooksUIAction(bookDatabase));
        menuNumberToActionMap.put(9, new PrintAllBooksUIAction(bookDatabase));
        menuNumberToActionMap.put(10, new GetAuthorToBooksMap(bookDatabase));
        menuNumberToActionMap.put(11, new GetEachAuthorBookCount(bookDatabase));
    }

    public void run(){
        Scanner sc = new Scanner(System.in);

        while (true) {
            menuNumberToActionMap.entrySet().forEach(x -> System.out.println(x.getKey() + " - " + x.getValue().getActionName()));
            System.out.println("PLease enter menu number: ");

            int userSelectedMenuNumber = Integer.parseInt(sc.nextLine());
            if (userSelectedMenuNumber == 0) {
                System.out.println("Thank you! Good by!");
                break;
            } else {
                executeUIAction(userSelectedMenuNumber);
            }
        }
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
