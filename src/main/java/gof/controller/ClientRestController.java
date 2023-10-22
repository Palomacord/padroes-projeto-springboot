package gof.controller;

import gof.model.Client;
import gof.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClientRestController {

    /**
     *
     */
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> insert(@RequestBody Client cliente) {
        clientService.insert(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Client cliente) {
        clientService.update(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }

}
