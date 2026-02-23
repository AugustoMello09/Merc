package io.github.augustomello09.merc.service;

import io.github.augustomello09.merc.dtos.ProductDTOResponse;
import io.github.augustomello09.merc.entities.Product;
import io.github.augustomello09.merc.enums.StatusState;
import io.github.augustomello09.merc.mappers.ProductMapper;
import io.github.augustomello09.merc.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional(readOnly = true)
    public Page<ProductDTOResponse> findCriticalProducts(Pageable pageable){
        Page<Product> productList = productRepository.findCriticalProducts(20, StatusState.ACTIVE, pageable);
        return productList.map(productMapper::toDto);
    }

}
