package javaProfessionalCourse2.lesson20_Exceptions.Exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionExample4 {
    public static void main(String[] args) {

        try {
            File file = new File("path");
            FileInputStream fis = new FileInputStream(file);
            String s = "inside";
        } catch (FileNotFoundException e) {
            System.out.println("fileNot found");

        }
    }
}
