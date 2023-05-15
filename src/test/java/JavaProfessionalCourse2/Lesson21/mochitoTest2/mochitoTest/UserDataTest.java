package JavaProfessionalCourse2.Lesson21.mochitoTest2.mochitoTest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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