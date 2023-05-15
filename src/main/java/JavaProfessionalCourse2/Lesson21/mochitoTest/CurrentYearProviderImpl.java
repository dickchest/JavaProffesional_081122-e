package JavaProfessionalCourse2.Lesson21.mochitoTest;

import java.time.LocalDate;
import java.util.Locale;

public class CurrentYearProviderImpl implements CurrentYearProvider{

    @Override
    public int getYear() {
        return LocalDate.now().getYear();
    }
}
