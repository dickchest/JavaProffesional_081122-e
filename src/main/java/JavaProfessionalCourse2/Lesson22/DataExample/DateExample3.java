package JavaProfessionalCourse2.Lesson22.DataExample;

import java.util.Date;
import java.util.Locale;

/*
locale
 */
public class DateExample3 {
    public static void main(String[] args) {

        Locale locale = new Locale("de");
        Locale.setDefault(locale);
        Date nowDate = new Date();

        String dateString = String.format(locale, "%tc\n", nowDate) +
                String.format(locale, "%tD\n", nowDate) +
                String.format(locale, "%tF\n", nowDate) +
                String.format(locale, "%tr\n", nowDate) +
                String.format(locale, "%tz\n", nowDate) +
                String.format(locale, "%tZ\n", nowDate);

        System.out.println(dateString);

    }
}
