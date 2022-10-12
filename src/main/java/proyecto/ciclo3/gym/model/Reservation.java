package proyecto.ciclo3.gym.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";

    @ManyToOne
    @JoinColumn(name = "machine_id")
    @JsonIgnoreProperties("reservations")
    private Gymmachine machine;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnoreProperties({ "reservations", "messages" })
    private Client client;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    public List<Score> score;

}
