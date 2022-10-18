package proyecto.ciclo3.gym.repository.crud;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import proyecto.ciclo3.gym.model.Reservation;

public interface ReservationRepositoryCrud extends CrudRepository<Reservation, Integer> {

    @Query("SELECT rs.client,COUNT(rs.client) FROM Reservation AS rs GROUP BY rs.client ORDER BY COUNT(rs.client) desc")
    public List<Object[]> countTotalReservationByClient();

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateone, Date datetwo);

    public List<Reservation> findAllByStatus(String status);

}
