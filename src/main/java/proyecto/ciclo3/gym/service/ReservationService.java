package proyecto.ciclo3.gym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.ciclo3.gym.model.Reservation;
import proyecto.ciclo3.gym.repository.ReservationRepository;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> listarReservation() {

        return reservationRepository.listReservation();

    }

    public Optional<Reservation> idReservation(int id) {

        return reservationRepository.IdReservation(id);

    }

    public Reservation guardarReservation(Reservation rs) {

        if (rs.getIdReservation() == null) {
            return reservationRepository.guardarReservation(rs);

        } else {

            Optional<Reservation> rst = reservationRepository.IdReservation(rs.getIdReservation());
            if (rst.isEmpty()) {
                return reservationRepository.guardarReservation(rs);

            } else {

                return rs;

            }

        }

    }

}
