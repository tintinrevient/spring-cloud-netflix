package io.github.tintinrevient.messageservice.dao;

import org.springframework.data.repository.CrudRepository;
import io.github.tintinrevient.messageservice.model.Message;
import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {
    public List<Message> findAll();
    public List<Message> findById(int id);
}
