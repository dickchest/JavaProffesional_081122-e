package homework.extraHomeworkProfCourse.profBookApp.core;

import lombok.Data;

@Data
public class Book {
    private Long id;
    private String title;
    private String author;
    private String yearOfIssue;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(String title, String author, String yearOfIssue) {
        this.title = title;
        this.author = author;
        this.yearOfIssue = yearOfIssue;
    }
}
