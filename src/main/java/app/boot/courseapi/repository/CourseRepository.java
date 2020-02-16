package app.boot.courseapi.repository;

import app.boot.courseapi.model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, String> {
    
    public List<Course> findByTopicId(String topicId);
}
