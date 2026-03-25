package com.marcosdias.desafionelio4.controllers;

import com.marcosdias.desafionelio4.dto.SaleReportDTO;
import com.marcosdias.desafionelio4.dto.SaleSummaryDTO;
import com.marcosdias.desafionelio4.services.SaleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/report")
    public Page<SaleReportDTO> searchSalesReport(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            @RequestParam(value = "name", defaultValue = "") String name,
            Pageable pageable
    ) {
        return saleService.searchSalesReport(minDate, maxDate, name, pageable);
    }

    @GetMapping("/summary")
    public List<SaleSummaryDTO> searchSalesSummary(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate
    ) {
        return saleService.searchSalesSummary(minDate, maxDate);
    }
}

