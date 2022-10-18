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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import proyecto.ciclo3.gym.model.Admin;
import proyecto.ciclo3.gym.service.AdminService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })

public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    private List<Admin> getAdmin() {

        return adminService.adminListar();

    }

    @GetMapping("/{id}")
    private Optional<Admin> getIdAdmin(@PathVariable int id) {
        return adminService.adminId(id);

    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin saveAdmin(@RequestBody Admin ad) {

        return adminService.adminGuardar(ad);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin ad) {

        return adminService.ActualizarAdmin(ad);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {

        return adminService.eliminarAdmin(id);

    }

}
