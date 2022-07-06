package com.learnfeignclient.currency.controller;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class AmountResponse {
    private BigDecimal result;
}
