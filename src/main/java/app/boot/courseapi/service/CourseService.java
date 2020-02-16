package app.boot.courseapi.service;

import app.boot.courseapi.model.Course;
import app.boot.courseapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId) {
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }
    public Course courseById(String id) {
        return courseRepository.findById(id).orElse(new Course());
//       return courses.stream().filter(t->t.getId().equals(id)).findFirst().orElse(new Course());
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(Course course, String id) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) { 
        courseRepository.deleteById(id);
    }
}
