package javaProfessionalCourse2.lesson28.homework.tasks1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PrimitiveIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/*
4. Написать метод, в котором 3 потока построчно пишут данные в файл (штук по 10 записей, с периодом в 20 мс)
 */
public class Exercise4 {
    /**
     * не уверен, что максимально лаконично решил данную задачу
     */
    private static final String FILE_PATH = "output.txt";
    private static final int THREAD_COUNT = 3;
    private static final int LINES_PER_THREAD = 10;
    private static final int DELAY_MS = 20;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        FileWriter fileWriter = null;
        Semaphore semaphore = new Semaphore(1);

        try {
            fileWriter = new FileWriter(FILE_PATH);

            for (int i = 0; i < THREAD_COUNT; i++) {
                int threadId = i + 1;
                executorService.execute(new Writer(fileWriter,semaphore, threadId));
                Thread.sleep(2000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
                executorService.shutdown();
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


    private static void writeDataToFile(FileWriter fileWriter, Semaphore semaphore, int threadID) {
        String threadName = "Thread " + threadID;
        try {
            for (int i = 0; i < LINES_PER_THREAD; i++) {
                semaphore.acquire();

                String line = threadName + " - Line " + i + "\n";
                fileWriter.write(line);
                System.out.print(line);
                Thread.sleep(DELAY_MS);

                semaphore.release();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("ошибка");
            e.printStackTrace();
        }
    }

    private static class Writer implements Runnable {
        FileWriter fileWriter;
        Semaphore semaphore;
        int threadId;

        public Writer(FileWriter fileWriter, Semaphore semaphore, int threadId) {
            this.fileWriter = fileWriter;
            this.semaphore = semaphore;
            this.threadId = threadId;
        }

        @Override
        public void run() {
            writeDataToFile(fileWriter, semaphore, threadId);
        }
    }
}

