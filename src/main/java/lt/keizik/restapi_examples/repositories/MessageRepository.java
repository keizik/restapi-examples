package lt.keizik.restapi_examples.repositories;

import org.springframework.data.repository.CrudRepository;

import lt.keizik.restapi_examples.dto.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {

}
