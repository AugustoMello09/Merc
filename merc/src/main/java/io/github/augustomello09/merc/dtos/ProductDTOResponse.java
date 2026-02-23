package io.github.augustomello09.merc.dtos;

import io.github.augustomello09.merc.enums.StatusState;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTOResponse {

    private Long id;

    private String name;

    private String category;

    private BigDecimal salePrice;

    private int stockQuantity;

    private StatusState statusState;

}
