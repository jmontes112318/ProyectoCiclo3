package proyecto.ciclo3.gym.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proyecto.ciclo3.gym.model.Message;
import proyecto.ciclo3.gym.repository.crud.MessageRepositoryCrud;

@Repository
public class MessageRepository {

    @Autowired
    private MessageRepositoryCrud messageRepositoryCrud;

    public List<Message> listMessage() {

        return (List<Message>) messageRepositoryCrud.findAll();

    }

    public Optional<Message> IdMessage(int id) {

        return messageRepositoryCrud.findById(id);

    }

    public Message guardarMessage(Message ms) {
        return messageRepositoryCrud.save(ms);

    }

}
