package com.sascode.crud.service;

import com.sascode.crud.domain.Client;
import com.sascode.crud.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public Optional<Client> findClient(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public Client saveClient(Client client)  {
        return clientRepository.save(client);
    }

    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client updateClient(Long id, Client client) {
        Client currentClient = clientRepository.findById(id).orElseThrow(RuntimeException::new);

        if (client.getName() != null && client.getName().length() > 0) {
            currentClient.setName(client.getName());
        }

        if (client.getEmail() != null && client.getEmail().length() > 0) {
            currentClient.setEmail(client.getEmail());
        }
        return currentClient;
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
