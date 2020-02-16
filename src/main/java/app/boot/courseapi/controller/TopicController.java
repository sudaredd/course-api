package app.boot.courseapi.controller;

import app.boot.courseapi.model.Topic;
import app.boot.courseapi.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;
    
    @RequestMapping("/topics")
    public List<Topic> getALlTopics() {
        return topicService.getAllTopics();    
    }
    
    @RequestMapping("/topics/{id}")
    public Topic findTopicById(@PathVariable String id) {
        return topicService.topicById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }  
    
    @RequestMapping(method = RequestMethod.PUT, value = "topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(topic, id);
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = "topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}
