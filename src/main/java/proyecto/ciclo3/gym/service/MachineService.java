package proyecto.ciclo3.gym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.ciclo3.gym.model.Gymmachine;
import proyecto.ciclo3.gym.repository.MachineRepository;

@Service
public class MachineService {
    @Autowired
    private MachineRepository machineRepository;

    public List<Gymmachine> listMachines() {

        return machineRepository.listarMachines();

    }

    public Optional<Gymmachine> listMachine(int id) {

        return machineRepository.listarIdMachine(id);

    }

    public Gymmachine guardarMachine(Gymmachine m) {

        if (m.getId() == null) {

            return machineRepository.guardarMachine(m);

        } else {
            Optional<Gymmachine> mach = machineRepository.listarIdMachine(m.getId());
            if (mach.isEmpty()) {

                return machineRepository.guardarMachine(m);

            } else {

                return m;

            }

        }

    }

}
