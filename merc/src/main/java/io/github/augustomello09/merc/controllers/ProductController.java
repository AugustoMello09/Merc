package io.github.augustomello09.merc.controllers;

import io.github.augustomello09.merc.dtos.ProductDTOResponse;
import io.github.augustomello09.merc.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
