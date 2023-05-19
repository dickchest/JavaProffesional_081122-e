package JavaProfessionalCourse2.Lesson20.Exceptions;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionExample3 {
    public static void main(String[] args) {
        FileWriter writer = null;

        try {
            writer = new FileWriter("out.txt");
            writer.write("Writing to the file");
            System.out.println("файл записан успешно");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    System.out.println("Ошибка закрытия файла");
                }
            }
        }
    }
}
