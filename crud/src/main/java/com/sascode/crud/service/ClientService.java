package com.sascode.crud.service;

import com.sascode.crud.domain.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAllClients();
    Client findClient(Long id);
    Client saveClient(Client client);
    Client updateClient(Long id, Client client);
    void deleteClient(Long id);
}
