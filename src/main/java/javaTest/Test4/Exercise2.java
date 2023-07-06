package javaTest.Test4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/*
Считать с консоли имя файла. Создать копию файла в той же директории, где лежит исходный файл. Имя копии должно быть тем же, что у исходного файла с префиксом copied_.
 */
public class Exercise2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла");
        String fileName = scanner.nextLine();

        File sourceFile = new File(fileName);
        System.out.println(sourceFile.getAbsolutePath());

        if (sourceFile.exists()) {
            try {
                String copiedFileName = "copied_" + fileName;
                File copiedFile = new File(sourceFile.getParent(), copiedFileName);
                Files.copy(sourceFile.toPath(), copiedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла " + e.getMessage());
            }
        } else {
            System.out.println("Файл не существует");
        }
    }
}
