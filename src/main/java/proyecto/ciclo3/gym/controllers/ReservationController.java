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

import proyecto.ciclo3.gym.model.Reservation;
import proyecto.ciclo3.gym.model.custom.CountClient;
import proyecto.ciclo3.gym.model.custom.StatusAmount;
import proyecto.ciclo3.gym.service.ReservationService;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })

public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAllReservations() {

        return reservationService.listarReservation();

    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id) {
        return reservationService.idReservation(id);

    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation saveReservation(@RequestBody Reservation rs) {
        return reservationService.guardarReservation(rs);

    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation rs) {

        return reservationService.ActualizarReservation(rs);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {

        return reservationService.eliminarReservation(id);

    }
    // Reto 05

    @GetMapping("/report-status")
    public StatusAmount getReservationStatus() {

        return reservationService.getStatusReport();

    }

    @GetMapping("/report-clients")
    public List<CountClient> getCountClient() {
        return reservationService.getTopClient();

    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getDateReport(@PathVariable("dateOne") String d1, @PathVariable("dateTwo") String d2) {

        return reservationService.getReservationPeriod(d1, d2);

    }

}
