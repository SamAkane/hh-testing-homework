package ru.hh.school.steps;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import ru.hh.school.helper.ApiClient;
import ru.hh.school.helper.VacanciesResponse;
import ru.hh.school.helper.VacanciesResponseHolder;

import java.io.IOException;

public class VacanciesStep {

    public VacanciesResponseHolder getVacancies(String parameter) throws IOException {
        ApiClient client = new ApiClient();
        Gson gson = new Gson();
        HttpResponse response = client.get("vacancies", parameter);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        VacanciesResponseHolder responseHolder = new VacanciesResponseHolder();
        responseHolder.setHttpStatus(response.getStatusLine().getStatusCode());
        VacanciesResponse vacanciesResponse = gson.fromJson(content, VacanciesResponse.class);
        if(vacanciesResponse != null) {
            responseHolder.setErrorCode(vacanciesResponse.getErrorCode());
            responseHolder.setData(vacanciesResponse.getData());
        }
        return responseHolder;
    }

    public void assertStatusCode(int expectedStatus, int actualStatus) {
        Assert.assertEquals("Http статус отличается от ожидаемого", expectedStatus, actualStatus);
    }

    public void assertErrorCode(int expectedErrorCode, int actualErrorCode) {
        Assert.assertEquals("Error code отличается от ожидаемого", expectedErrorCode, actualErrorCode);
    }

    public void assertResponseContainsParams(VacanciesResponseHolder response) {

    }
}
