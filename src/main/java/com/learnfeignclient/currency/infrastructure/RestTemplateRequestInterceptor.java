package com.learnfeignclient.currency.infrastructure;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class RestTemplateRequestInterceptor implements ClientHttpRequestInterceptor {

    private static final String API_KEY_HEADER_KEY = "apikey";

    private final String apiKeyHeaderValue;

    public RestTemplateRequestInterceptor(String apiKeyHeaderValue) {
        this.apiKeyHeaderValue = apiKeyHeaderValue;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
        headers.add(API_KEY_HEADER_KEY, apiKeyHeaderValue);
        return execution.execute(request, body);
    }
}
