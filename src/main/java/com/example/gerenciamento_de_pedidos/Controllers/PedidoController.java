package com.example.gerenciamento_de_pedidos.Controllers;

import com.example.gerenciamento_de_pedidos.Models.PedidosModels;
import com.example.gerenciamento_de_pedidos.Services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.PushbackInputStream;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    //criar
    @PostMapping
    public ResponseEntity<PedidosModels> criar(@RequestBody PedidosModels pedidosModels){
        PedidosModels pedidos = pedidoService.adicionar(pedidosModels);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pedidos.getId())
                .toUri();
        return ResponseEntity.created(uri).body(pedidos);
    }

    //listar todos
    @GetMapping
    public ResponseEntity<List<PedidosModels>>buscarTudo(){
        List<PedidosModels> request = pedidoService.buscarTudo();
    return ResponseEntity.ok(request);
    }

    //buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<PedidosModels>buscarPorId(@PathVariable Long id){
        PedidosModels pedido = pedidoService.buscarId(id);
    return ResponseEntity.ok(pedido);
    }

    //atualizar
    @PutMapping("/{id}")
    public ResponseEntity<PedidosModels> atualizarPedidos(@PathVariable Long id, @RequestBody PedidosModels pedidosModels){
        PedidosModels pedidoAtualizado = pedidoService.atualizar(id,pedidosModels);
        return ResponseEntity.ok(pedidoAtualizado);
    }

    // deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPedido(@PathVariable Long id){
        pedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

