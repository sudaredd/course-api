package app.boot.courseapi.repository;

import app.boot.courseapi.model.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {
    
}
