package proyecto.ciclo3.gym.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proyecto.ciclo3.gym.model.Admin;
import proyecto.ciclo3.gym.repository.crud.AdmidRepositoryCrud;

@Repository
public class AdminRepository {
    @Autowired
    private AdmidRepositoryCrud admidRepositoryCrud;

    public List<Admin> listAdmin() {

        return (List<Admin>) admidRepositoryCrud.findAll();

    }

    public Optional<Admin> adminId(int id) {

        return admidRepositoryCrud.findById(id);

    }

    public Admin guardarAdmin(Admin ad) {
        return admidRepositoryCrud.save(ad);
    }

    public void borrarAdmin(Admin ad) {
        admidRepositoryCrud.delete(ad);
    }

}
