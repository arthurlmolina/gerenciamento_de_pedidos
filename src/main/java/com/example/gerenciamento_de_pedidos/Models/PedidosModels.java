package com.example.gerenciamento_de_pedidos.Models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Table(name = "tb_pedido")

public class PedidosModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dataHora")
    private LocalDateTime localDataHora;

    @Column(name = "totalValor")
    private BigDecimal valorTotal;

    private String status;

    public PedidosModels() {
    }

    public PedidosModels(LocalDateTime localDataHora, BigDecimal valorTotal, String status) {
        this.localDataHora = localDataHora;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getLocalDataHora() {
        return localDataHora;
    }

    public void setLocalDataHora(LocalDateTime localDataHora) {
        this.localDataHora = localDataHora;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}