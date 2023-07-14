package homework.extraHomeworkProfCourse.profBookApp.tests;

import homework.extraHomeworkProfCourse.profBookApp.core.Book;
import homework.extraHomeworkProfCourse.profBookApp.search.*;

public class SearchCriteriaDemo {
    public static void main(String[] args) {
        Book book1 = new Book("A1", "B1", "1992");
        Book book2 = new Book("A2", "B2", "1992");
        Book book3 = new Book("A3", "B2", "2000");

        SearchCriteria searchByAuthor = new AuthorSearchCriteria("B1");
        SearchCriteria searchByTitle = new TitleSearchCriteria("A2");
        SearchCriteria searchByYear = new YearOfIssueSearchCriteria("1992");
        SearchCriteria andSearchCriteria = new AndSearchCriteria(searchByAuthor, searchByYear);
        SearchCriteria orSearchCriteria = new OrSearchCriteria(searchByAuthor, searchByYear);


        System.out.println(searchByAuthor.match(book1));
        System.out.println(searchByAuthor.match(book2));
        System.out.println("----");

        System.out.println(searchByTitle.match(book1));
        System.out.println(searchByTitle.match(book2 ));
        System.out.println("----");

        System.out.println(searchByYear.match(book1));
        System.out.println(searchByYear.match(book2));
        System.out.println(searchByYear.match(book3));
        System.out.println("----");

        System.out.println(andSearchCriteria.match(book1));
        System.out.println(andSearchCriteria.match(book2));
        System.out.println("----");

        System.out.println(orSearchCriteria.match(book1));
        System.out.println(orSearchCriteria.match(book2));
        System.out.println(orSearchCriteria.match(book3));



    }
}
