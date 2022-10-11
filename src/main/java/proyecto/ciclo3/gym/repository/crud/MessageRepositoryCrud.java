package proyecto.ciclo3.gym.repository.crud;

import org.springframework.data.repository.CrudRepository;

import proyecto.ciclo3.gym.model.Message;

public interface MessageRepositoryCrud extends CrudRepository<Message, Integer> {

}
