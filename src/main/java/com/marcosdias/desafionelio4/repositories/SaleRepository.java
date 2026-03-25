package com.marcosdias.desafionelio4.repositories;

import com.marcosdias.desafionelio4.dto.SaleReportDTO;
import com.marcosdias.desafionelio4.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("""
            SELECT new com.marcosdias.desafionelio4.dto.SaleReportDTO(
                s.id,
                s.date,
                s.amount,
                s.seller.name
            )
            FROM Sale s
            WHERE s.date BETWEEN :minDate AND :maxDate
            AND UPPER(s.seller.name) LIKE UPPER(CONCAT('%', :name, '%'))
            """)
    Page<SaleReportDTO> searchSalesReport(
            @Param("minDate") LocalDate minDate,
            @Param("maxDate") LocalDate maxDate,
            @Param("name") String name,
            Pageable pageable
    );
}

