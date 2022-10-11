package proyecto.ciclo3.gym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.ciclo3.gym.model.Client;
import proyecto.ciclo3.gym.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> listClient() {
        return clientRepository.listClient();

    }

    public Optional<Client> listClienId(int id) {

        return clientRepository.listClientid(id);

    }

    public Client guardarClient(Client cl) {

        if (cl.getIdClient() == null) {

            return clientRepository.guardarClient(cl);

        } else {
            Optional<Client> cli = clientRepository.listClientid(cl.getIdClient());
            if (cli.isEmpty()) {
                return clientRepository.guardarClient(cl);

            } else {

                return cl;

            }

        }

    }

}
