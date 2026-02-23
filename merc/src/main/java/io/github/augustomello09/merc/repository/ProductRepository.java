package io.github.augustomello09.merc.repository;

import io.github.augustomello09.merc.entities.Product;
import io.github.augustomello09.merc.enums.StatusState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = """
     SELECT produto FROM Product produto
     WHERE produto.stockQuantity < :limit AND
     produto.statusState = :status ORDER BY produto.stockQuantity ASC        
     """)
    Page<Product> findCriticalProducts(@Param("limit") int limit, @Param("status") StatusState status, Pageable pageable);


}
