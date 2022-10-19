package proyecto.ciclo3.gym.model.custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import proyecto.ciclo3.gym.model.Client;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CountClient {
    private Long total;
    private Client client;
}
