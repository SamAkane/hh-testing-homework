package ru.hh.school.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.hh.school.helper.VacanciesResponseHolder;
import ru.hh.school.steps.VacanciesStep;

import java.io.IOException;
import org.apache.http.HttpResponse;

@RunWith(Parameterized.class)
public class VacanciesTest {
    private VacanciesStep step = new VacanciesStep();

    @Test
    public void test() throws IOException {
        VacanciesResponseHolder response = step.getVacancies(parameter);
        step.assertStatusCode(expectedHttpStatus, response.getHttpStatus());
        step.assertErrorCode(expectedErrorCode, response.getErrorCode());
    }

    @Parameterized.Parameter(0)
    public String testName;

    @Parameterized.Parameter(1)
    public String parameter;

    @Parameterized.Parameter(2)
    public int expectedHttpStatus;

    @Parameterized.Parameter(3)
    public int expectedErrorCode;

    @Parameterized.Parameters
    public static Object[][] __data() {
        return new Object[][] {
                {"1", "Java", 200, 0},
        };
    }

}
