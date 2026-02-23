package io.github.augustomello09.merc.mappers;

import io.github.augustomello09.merc.dtos.ProductDTOResponse;
import io.github.augustomello09.merc.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTOResponse toDto(Product entity);
}
