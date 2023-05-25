package javaProfessionalCourse2.lesson21_test_junit_mochito.mochitoTest2.mochitoTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserDataTest {

    @Test
    void checkData() {
        InputData inputData = mock(InputData.class);

        when(inputData.getData()).thenReturn(100);

        int actualData = inputData.getData();

        assertEquals(100, actualData);
    }
}