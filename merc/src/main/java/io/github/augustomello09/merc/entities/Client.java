package io.github.augustomello09.merc.entities;

import io.github.augustomello09.merc.enums.StatusClient;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "client_tb")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "cpf", unique = true, nullable = false)
    private String cpf;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "internal_score", nullable = false)
    private int internalScore;

    @Column(name = "credit_limit", nullable = false)
    private BigDecimal creditLimit;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_client", nullable = false)
    private StatusClient statusClient;

    protected Client() {}

    public Client(String email, String cpf, String name) {
        validate(email, cpf, name);
        this.statusClient = StatusClient.ACTIVE;
        this.creditLimit = BigDecimal.ZERO;
        this.internalScore = 0;
        this.createdAt = LocalDateTime.now();
        this.email = email;
        this.cpf = cpf;
        this.name = name;
    }

    private void validate(String email, String cpf, String name) {
        if (email == null || email.isBlank()) throw new IllegalArgumentException("Email inválido");
        if (cpf == null || cpf.isBlank()) throw new IllegalArgumentException("CPF inválido");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Nome inválido");
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getInternalScore() {
        return internalScore;
    }

    public StatusClient getStatusClient() {
        return statusClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client other)) return false;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
