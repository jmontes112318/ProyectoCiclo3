package proyecto.ciclo3.gym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.ciclo3.gym.model.Message;
import proyecto.ciclo3.gym.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> listarMessages() {

        return messageRepository.listMessage();

    }

    public Optional<Message> idMessage(int id) {

        return messageRepository.IdMessage(id);

    }

    public Message guarMessage(Message ms) {

        if (ms.getIdMessage() == null) {
            return messageRepository.guardarMessage(ms);

        } else {

            Optional<Message> msj = messageRepository.IdMessage(ms.getIdMessage());
            if (msj.isEmpty()) {
                return messageRepository.guardarMessage(ms);

            } else {

                return ms;

            }

        }

    }

    public Message ActualizarMessage(Message m) {

        if (m.getIdMessage() != null) {

            Optional<Message> ms = messageRepository.IdMessage(m.getIdMessage());

            if (!ms.isEmpty()) {

                if (m.getMessageText() != null) {
                    ms.get().setMessageText(m.getMessageText());
                }

                
                return messageRepository.guardarMessage(ms.get());

            }

        }

        return m;

    }

  

    public boolean eliminarMessage(int id) {

        Optional<Message> ms = idMessage(id);
        if (!ms.isEmpty()) {
            messageRepository.borrarMessage(ms.get());
            return true;

        }
        return false;

    }

}
