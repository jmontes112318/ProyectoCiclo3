package proyecto.ciclo3.gym.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proyecto.ciclo3.gym.model.Gymmachine;

import proyecto.ciclo3.gym.repository.crud.MachineRepositoryCrud;

@Repository
public class MachineRepository {

    @Autowired
    private MachineRepositoryCrud machineRepositoryCrud;

    public List<Gymmachine> listarMachines() {

        return (List<Gymmachine>) machineRepositoryCrud.findAll();

    }

    public Optional<Gymmachine> listarIdMachine(int id) {
        return machineRepositoryCrud.findById(id);
    }

    public Gymmachine guardarMachine(Gymmachine m) {
        return machineRepositoryCrud.save(m);
    }

    public void borrarMachine(Gymmachine m) {
        machineRepositoryCrud.delete(m);
    }

}
