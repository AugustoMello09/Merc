package io.github.augustomello09.merc.entities;

import io.github.augustomello09.merc.enums.StatusState;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product_tb")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "cost_price", nullable = false)
    private BigDecimal costPrice;

    @Column(name = "sale_price", nullable = false)
    private BigDecimal salePrice;

    @Column(name = "stock_quantity", nullable = false)
    private int stockQuantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_product", nullable = false)
    private StatusState statusState;

    protected Product() {}

    public Product(String name, String category, BigDecimal costPrice, BigDecimal salePrice, int stockQuantity) {
        validate(name,category,costPrice,stockQuantity, salePrice);
        this.name = name;
        this.category = category;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.stockQuantity = stockQuantity;
        this.statusState = StatusState.ACTIVE;
    }

    private void validate(String name, String category, BigDecimal costPrice, int stockQuantity, BigDecimal salePrice) {
        if (stockQuantity < 0 ) throw new IllegalArgumentException("Estoque inválido");
        if (costPrice.compareTo(BigDecimal.ZERO) < 0 ) throw new IllegalArgumentException("Preço Custo inválido");
        if (salePrice.compareTo(BigDecimal.ZERO) < 0 ) throw new IllegalArgumentException("Preço Venda inválido");
        if (category == null || category.isBlank()) throw new IllegalArgumentException("Categoria inválido");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Nome inválido");
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public StatusState getStatusState() {
        return statusState;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product other)) return false;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
