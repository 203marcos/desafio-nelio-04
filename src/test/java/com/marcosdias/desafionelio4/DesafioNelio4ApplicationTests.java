package com.marcosdias.desafionelio4;

import com.marcosdias.desafionelio4.dto.SaleReportDTO;
import com.marcosdias.desafionelio4.dto.SaleSummaryDTO;
import com.marcosdias.desafionelio4.services.SaleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DesafioNelio4ApplicationTests {

    @Autowired
    private SaleService saleService;

    @Test
    void shouldReturnSalesSummaryByPeriod() throws Exception {
        List<SaleSummaryDTO> result = saleService.searchSalesSummary("2022-01-01", "2022-06-30");

        assertEquals(5, result.size());
        assertEquals("Anakin", result.get(0).getSellerName());
        assertEquals(110571.0, result.get(0).getTotal());
        assertEquals("Logan", result.get(1).getSellerName());
        assertEquals(83587.0, result.get(1).getTotal());
        assertEquals("Loki Odinson", result.get(2).getSellerName());
        assertEquals(150597.0, result.get(2).getTotal());
        assertEquals("Padme", result.get(3).getSellerName());
        assertEquals(135902.0, result.get(3).getTotal());
        assertEquals("Thor Odinson", result.get(4).getSellerName());
        assertEquals(144896.0, result.get(4).getTotal());
    }

    @Test
    void shouldReturnSalesReportByNameAndPeriod() throws Exception {
        Page<SaleReportDTO> result = saleService.searchSalesReport(
                "2022-05-01",
                "2022-05-31",
                "odinson",
                PageRequest.of(0, 20)
        );

        assertEquals(3, result.getContent().size());
        assertEquals(9L, result.getContent().get(0).getId());
        assertEquals(19476.0, result.getContent().get(0).getAmount());
        assertEquals("Loki Odinson", result.getContent().get(0).getSellerName());
        assertEquals(10L, result.getContent().get(1).getId());
        assertEquals(20530.0, result.getContent().get(1).getAmount());
        assertEquals("Thor Odinson", result.getContent().get(1).getSellerName());
        assertEquals(12L, result.getContent().get(2).getId());
        assertEquals(21753.0, result.getContent().get(2).getAmount());
        assertEquals("Loki Odinson", result.getContent().get(2).getSellerName());
    }

}
