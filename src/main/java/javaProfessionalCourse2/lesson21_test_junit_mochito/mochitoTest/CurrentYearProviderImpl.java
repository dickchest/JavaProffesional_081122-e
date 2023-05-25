package javaProfessionalCourse2.lesson21_test_junit_mochito.mochitoTest;

import java.time.LocalDate;

public class CurrentYearProviderImpl implements CurrentYearProvider{

    @Override
    public int getYear() {
        return LocalDate.now().getYear();
    }
}
