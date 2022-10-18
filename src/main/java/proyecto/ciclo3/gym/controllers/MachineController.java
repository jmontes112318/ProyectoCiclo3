package proyecto.ciclo3.gym.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import proyecto.ciclo3.gym.model.Gymmachine;
import proyecto.ciclo3.gym.service.MachineService;

@RestController
@RequestMapping("/api/Machine")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })

public class MachineController {

    @Autowired
    private MachineService machineService;

    @GetMapping("/all")
    public List<Gymmachine> getAllMachines() {

        return machineService.listMachines();

    }

    @GetMapping("/{id}")
    public Optional<Gymmachine> getMachine(@PathVariable("id") int id) {
        return machineService.listMachine(id);

    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Gymmachine saveMachine(@RequestBody Gymmachine m) {
        return machineService.guardarMachine(m);

    }

    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Gymmachine update(@RequestBody Gymmachine mch) {

        return machineService.ActualizarMachine(mch);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {

        return machineService.eliminarMachine(id);

    }

}
