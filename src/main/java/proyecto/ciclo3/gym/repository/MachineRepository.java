package proyecto.ciclo3.gym.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proyecto.ciclo3.gym.model.Machine;
import proyecto.ciclo3.gym.repository.crud.MachineRepositoryCrud;

@Repository
public class MachineRepository {

    @Autowired
    private MachineRepositoryCrud machineRepositoryCrud;

    public List<Machine> listarMachines() {

        return (List<Machine>) machineRepositoryCrud.findAll();

    }

    public Optional<Machine> listarIdMachine(int id) {
        return machineRepositoryCrud.findById(id);
    }

    public Machine guardarMachine(Machine m) {
        return machineRepositoryCrud.save(m);
    }

}
