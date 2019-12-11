package ru.hh.school.helper;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;

import java.io.IOException;

public class ApiClient {
    private final static String BASE_URL = "https://api.hh.ru/";
    //https://api.hh.ru/vacancies?text=java
    protected HttpClient client;

    public ApiClient() {
        client = HttpClientBuilder.create().build();
    }

    public HttpResponse get(String endpoint, String parameter/*, BasicHeader ... headers*/) throws IOException {
        HttpClient client = HttpClients.createDefault();

        HttpGet get = new HttpGet(BASE_URL + endpoint + "?text=" + parameter);
        /*for (BasicHeader head : headers) {
            get.setHeader(head.getName(), head.getValue());
        }*/

        HttpResponse response = client.execute(get);
        return response;
    }


}
