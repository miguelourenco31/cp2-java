package br.com.fiap.checkpoint2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Pedidos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nome do cliente é obrigatório")
    private String clientName;

    private LocalDate orderDate;

    @DecimalMin(value = "0.0", message = "Valor não pode ser negativo")
    @Positive
    private BigDecimal totalValue;

    @PrePersist
    public void prePersist() {
        if (orderDate == null) {
            orderDate = LocalDate.now();
        }
    }
}
