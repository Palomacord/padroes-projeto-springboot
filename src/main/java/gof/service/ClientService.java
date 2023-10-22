package gof.service;

import gof.model.Client;

public interface  ClientService {

    Iterable<Client> findAll();
    Client findById(Long id);
    void insert(Client cliente);
    void update(Long id, Client cliente);
    void delete(Long id);
}
