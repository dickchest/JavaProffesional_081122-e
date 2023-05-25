package javaProfessionalCourse2.lesson22_mochito.DataExample;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
locale
 */
public class DateExample4 {
    public static void main(String[] args) {

        // грегорианский каллендарь
        // get()
        GregorianCalendar day = new GregorianCalendar(2022, Calendar.DECEMBER, 20);
        int month = day.get(Calendar.MONTH);
        System.out.println(month);
        System.out.println(day);

        // set()
        day = new GregorianCalendar(1975, Calendar.DECEMBER, 31);
        day.set(1976,Calendar.FEBRUARY, 23);
        System.out.println(day.get(Calendar.MONTH));

        // add()
        day = new GregorianCalendar(1975, Calendar.DECEMBER, 31);
        day.add(Calendar.MONTH, 2);
        System.out.println(day.get(Calendar.MONTH));

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = formatter.format(new Date());
        System.out.println(dateString);

        Calendar calendar = Calendar.getInstance();
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = formatter.format(calendar.getTime());
        System.out.println(formattedDate);

    }
}
