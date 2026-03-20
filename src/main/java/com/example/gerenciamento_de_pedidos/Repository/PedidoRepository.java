package com.example.gerenciamento_de_pedidos.Repository;

import com.example.gerenciamento_de_pedidos.Models.PedidosModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository <PedidosModels, Long> {
}
