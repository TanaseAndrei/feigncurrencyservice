package com.learnfeignclient.currency.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class ConversionData {
    private final String from;
    private final String to;
    private final BigDecimal amount;
}
