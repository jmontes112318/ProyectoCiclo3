package proyecto.ciclo3.gym.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

@Entity
@Table(name = "machine")
@Data
@AllArgsConstructor

public class Machine implements Serializable {

    public Machine() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String brand;
    @Column(name = "years")
    private Integer year;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("machines")
    private Category category;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "machine")
    @JsonIgnoreProperties({ "machine", "client" })
    public List<Message> messages;

    @OneToMany(cascade = { CascadeType.PERSIST }, mappedBy = "machine")
    @JsonIgnoreProperties("machine")
    public List<Reservation> reservations;

}
