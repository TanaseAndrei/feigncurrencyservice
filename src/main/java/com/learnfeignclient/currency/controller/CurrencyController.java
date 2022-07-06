package com.learnfeignclient.currency.controller;

import com.learnfeignclient.currency.infrastructure.ApiLayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/currency")
@AllArgsConstructor
public class CurrencyController {

    private final ApiLayerService apiLayerService;

    @GetMapping("/convert")
    public AmountResponse convert(@RequestParam("from") String from, @RequestParam("to") String to,
                                  @RequestParam("amount") BigDecimal amount) {
        return apiLayerService.convert(new ConversionData(from, to, amount));
    }
}
