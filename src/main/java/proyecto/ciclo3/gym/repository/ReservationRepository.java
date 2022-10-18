package proyecto.ciclo3.gym.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proyecto.ciclo3.gym.model.Reservation;
import proyecto.ciclo3.gym.repository.crud.ReservationRepositoryCrud;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationRepositoryCrud reservationRepositoryCrud;

    public List<Reservation> listReservation() {

        return (List<Reservation>) reservationRepositoryCrud.findAll();
    }

    public Optional<Reservation> IdReservation(int id) {

        return reservationRepositoryCrud.findById(id);

    }

    public Reservation guardarReservation(Reservation rs) {
        return reservationRepositoryCrud.save(rs);

    }
    public void borrarReservation(Reservation rs) {
        reservationRepositoryCrud.delete(rs);
    }


}
