package javaProfessionalCourse2.lesson22_mochito.DataExample;

import java.util.Date;

public class DateExample2 {
    public static void main(String[] args) {
        Date date1 = new Date(100,11,21);
        Date date2 = new Date();
        Date date3 = new Date(110,1,3);

        System.out.println(date1);

        boolean isAfter = date3.after(date1);
        System.out.println("Date " + date3 + " comes after date " + date1 + " : " + isAfter);

        isAfter = date3.after(date2);
        System.out.println("Date " + date3 + " comes after date " + date2 + " : " + isAfter);

        int millisec = date1.compareTo(date2);

        System.out.println(millisec);
        System.out.println("Milliseconds from Jan 1 1970 to date " + date1 + " is " + date1.getTime());

        System.out.println("Before setting " + date2);

        // необходимо в базе данных, тк. обычно дата в милисекундах в БД
        date2.setTime(204587433443L);
        System.out.println();

        System.out.println("After setting " + date2);




    }
}
