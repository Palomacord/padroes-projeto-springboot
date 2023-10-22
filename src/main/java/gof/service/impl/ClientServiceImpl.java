package gof.service.impl;

import gof.model.Address;
import gof.model.AddressRepository;
import gof.model.Client;
import gof.model.ClientRepository;
import gof.service.ClientService;
import gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    // Singleton: Injetar os componentes do Spring com @Autowired.
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Client> findAll() {
        // Buscar todos os Clientes.
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        // Buscar Cliente por ID.
        Optional<Client> cliente = clientRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void insert(Client cliente) {
        saveClientCep(cliente);
    }

    @Override
    public void update(Long id, Client client) {
        // Buscar Cliente por ID, caso exista:
        Optional<Client> clienteBd = clientRepository.findById(id);
        if (clienteBd.isPresent()) {
            saveClientCep(client);
        }
    }

    @Override
    public void delete(Long id) {
        // Deletar Cliente por ID.
        clientRepository.deleteById(id);
    }

    private void saveClientCep(Client cliente) {
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = cliente.getAddress().getCep();
        Address endereco = addressRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Address novoEndereco = viaCepService.consultCep(cep);
            addressRepository.save(novoEndereco);
            return novoEndereco;
        });
        cliente.setAddress(endereco);
        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        clientRepository.save(cliente);
    }

}
