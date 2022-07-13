package com.bergamascodev.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", nullable = false, length = 150)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @Column(name = "valor")
    private BigDecimal valor;
}
