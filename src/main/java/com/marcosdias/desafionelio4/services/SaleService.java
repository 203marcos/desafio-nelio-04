package com.marcosdias.desafionelio4.services;

import com.marcosdias.desafionelio4.dto.SaleReportDTO;
import com.marcosdias.desafionelio4.repositories.SaleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Page<SaleReportDTO> searchSalesReport(String minDate, String maxDate, String name, Pageable pageable) {
        LocalDate max = parseMaxDate(maxDate);
        LocalDate min = parseMinDate(minDate, max);
        String sellerName = name == null ? "" : name;

        return saleRepository.searchSalesReport(min, max, sellerName, pageable);
    }

    private LocalDate parseMaxDate(String maxDate) {
        if (maxDate == null || maxDate.isBlank()) {
            return LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        }
        return LocalDate.parse(maxDate);
    }

    private LocalDate parseMinDate(String minDate, LocalDate maxDate) {
        if (minDate == null || minDate.isBlank()) {
            return maxDate.minusYears(1L);
        }
        return LocalDate.parse(minDate);
    }
}

