package ru.hh.school.steps;

import org.apache.http.HttpResponse;
import ru.hh.school.helper.ApiClient;

import java.io.IOException;

public class VacanciesStep {

    public HttpResponse getVacancies(String parameter) throws IOException {
        ApiClient client = new ApiClient();
        return client.get("vacancies", parameter);
    }

    public void assertStatusCode() {

    }

    public void assertErrorCode() {

    }
}
