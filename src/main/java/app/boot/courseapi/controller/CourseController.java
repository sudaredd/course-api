package app.boot.courseapi.controller;

import app.boot.courseapi.model.Course;
import app.boot.courseapi.model.Topic;
import app.boot.courseapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;
    
    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getALlCourses(@PathVariable String topicId) {
        return courseService.getAllCourses(topicId);    
    }
    
    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course findCourseById(@PathVariable String id) {
        return courseService.courseById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "topics/{id}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String id) {
        course.setTopic(new Topic(id, "", ""));
        courseService.addCourse(course);
    }  
    
    @RequestMapping(method = RequestMethod.PUT, value = "topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course,  @PathVariable String topicId, @PathVariable String id) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(course, id);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "topics/{id}/courses/{id}")
    public void deleteCourse(@RequestBody Course course, @PathVariable String id,  @PathVariable String topicId) {
        course.setTopic(new Topic(topicId, "", ""));
        courseService.deleteCourse(id);
    }
}
