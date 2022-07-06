package com.learnfeignclient.currency.infrastructure;

import com.learnfeignclient.currency.controller.AmountResponse;
import com.learnfeignclient.currency.controller.ConversionData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ApiLayerService {

    private final RestTemplate restTemplate;
    private final String conversionUrl;

    public ApiLayerService(RestTemplate restTemplate, @Value("${apilayer.currency.conversionUrl}") String conversionUrl) {
        this.restTemplate = restTemplate;
        this.conversionUrl = conversionUrl;
    }

    public AmountResponse convert(ConversionData conversionData) {
        String path = createPath(conversionData);
        ResponseEntity<AmountResponse> response = restTemplate.getForEntity(path, AmountResponse.class);
        return response.getBody();
    }

    private String createPath(ConversionData conversionData) {
        return UriComponentsBuilder.fromPath(conversionUrl)
                .build(conversionData.getTo(), conversionData.getFrom(), conversionData.getAmount())
                .getPath();
    }
}
