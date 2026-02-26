package io.github.augustomello09.merc.controllers;

import io.github.augustomello09.merc.dtos.ProductDTOResponse;
import io.github.augustomello09.merc.dtos.ProductSummaryDTO;
import io.github.augustomello09.merc.enums.StatusState;
import io.github.augustomello09.merc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping(value = "/criticalProducts")
    public ResponseEntity<Page<ProductDTOResponse>> findAllCriticalProducts(Pageable pageable) {
        Page<ProductDTOResponse> response = service.findCriticalProducts(pageable);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ProductDTOResponse>> findByPrecoBetweenAndNomeStartingWithAndEstoqueNot(
            @RequestParam("minPrice") BigDecimal min,
            @RequestParam("maxPrice") BigDecimal max,
            @RequestParam("nameStartsWith") String starts,
            Pageable pageable) {

        Page<ProductDTOResponse> response = service.findByPrecoBetweenAndNomeStartingWithAndEstoqueNot(min, max, starts, pageable);

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/findActiveProduct")
    public ResponseEntity<Page<ProductSummaryDTO>> getFilteredProducts(
            Pageable pageable,
            @RequestParam("status") StatusState status
            ) {
            Page<ProductSummaryDTO> responses = service.findActiveProductSummaryOrderByPriceDesc(status, pageable);
            return ResponseEntity.ok().body(responses);
    }
}
