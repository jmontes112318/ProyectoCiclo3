package proyecto.ciclo3.gym.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proyecto.ciclo3.gym.model.Client;
import proyecto.ciclo3.gym.model.Reservation;
import proyecto.ciclo3.gym.model.custom.CountClient;

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

    public List<Reservation> getReservationByClient(String status) {
        return reservationRepositoryCrud.findAllByStatus(status);
    }

    public List<Reservation> getReservationPeriod(Date dateone, Date datetwo) {
        return reservationRepositoryCrud.findAllByStartDateAfterAndStarDateBefore(dateone, datetwo);

    }

    public List<CountClient> getTopClient() {

        List<CountClient> res = new ArrayList<>();

        List<Object[]> report = reservationRepositoryCrud.countTotalReservationByClient();
        for (int i = 0; i < report.size(); i++) {

            res.add(new CountClient((Integer) report.get(i)[1], (Client) report.get(i)[0]));
        }

        return res;

    }

}
