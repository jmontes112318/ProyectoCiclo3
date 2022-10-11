package proyecto.ciclo3.gym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.ciclo3.gym.model.Admin;
import proyecto.ciclo3.gym.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> adminListar() {

        return adminRepository.listAdmin();

    }

    public Optional<Admin> adminId(int id) {

        return adminRepository.idAdmin(id);

    }

    public Admin adminGuardar(Admin ad) {
        if (ad.getIdAdmin() == null) {
            return adminRepository.guardarAdmin(ad);

        } else {

            Optional<Admin> adm = adminRepository.idAdmin(ad.getIdAdmin());
            if (adm.isEmpty()) {

                return adminRepository.guardarAdmin(ad);

            } else {
                return ad;
            }

        }

    }

}
