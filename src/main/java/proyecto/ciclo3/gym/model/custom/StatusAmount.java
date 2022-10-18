package proyecto.ciclo3.gym.model.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StatusAmount {

    private Integer completed;
    private Integer cancelled;

}
