package proyecto.ciclo3.gym.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proyecto.ciclo3.gym.model.Client;
import proyecto.ciclo3.gym.repository.crud.ClientRepositoryCrud;

@Repository
public class ClientRepository {

    @Autowired
    private ClientRepositoryCrud clientRepositoryCrud;

    public List<Client> listClient() {

        return (List<Client>) clientRepositoryCrud.findAll();

    }

    public Optional<Client> listClientid(int id) {

        return clientRepositoryCrud.findById(id);

    }

    public Client guardarClient(Client cl) {

        return clientRepositoryCrud.save(cl);
    }

    public void borrarCLient(Client cl) {
        clientRepositoryCrud.delete(cl);
    }

}
