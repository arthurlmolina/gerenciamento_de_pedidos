package com.example.gerenciamento_de_pedidos.Services;

import com.example.gerenciamento_de_pedidos.Models.PedidosModels;
import com.example.gerenciamento_de_pedidos.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    //add
    public PedidosModels adicionar(PedidosModels pedidosModels){
        return pedidoRepository.save(pedidosModels);
    }

    //buscar
    public List<PedidosModels> buscarTudo(){
        return pedidoRepository.findAll();
    }

    //buscaId
    public PedidosModels buscarId(Long id){
        return pedidoRepository.findById(id).orElse(null);
    }

    //deletar
    public void deletar(Long id){
        pedidoRepository.deleteById(id);
    }

    //atualizar
    public PedidosModels atualizar(Long id, PedidosModels pedidosModels){
        PedidosModels novoPedido = pedidoRepository.findById(id).orElse(null);
        novoPedido.setStatus(pedidosModels.getStatus());
        novoPedido.setValorTotal(pedidosModels.getValorTotal());
        novoPedido.setLocalDataHora(pedidosModels.getLocalDataHora());
        return pedidoRepository.save(novoPedido);
    }
}
