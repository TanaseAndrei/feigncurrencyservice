package com.learnfeignclient.currency.infrastructure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("apilayer.currency")
@Component
@Setter
@Getter
public class ApiLayerConnectionConfiguration {
    private String baseUrl;
    private String key;
}
