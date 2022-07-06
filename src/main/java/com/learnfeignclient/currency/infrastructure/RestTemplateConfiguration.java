package com.learnfeignclient.currency.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.Collections;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate restTemplate(ApiLayerConnectionConfiguration apiLayerConnectionConfiguration) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(apiLayerConnectionConfiguration.getBaseUrl()));
        RestTemplateRequestInterceptor restTemplateRequestInterceptor =
                new RestTemplateRequestInterceptor(apiLayerConnectionConfiguration.getKey());
        restTemplate.setInterceptors(Collections.singletonList(restTemplateRequestInterceptor));
        return restTemplate;
    }
}
