package app.boot.courseapi.service;

import app.boot.courseapi.model.Topic;
import app.boot.courseapi.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    
    @Autowired
    private TopicRepository topicRepository;

    @PostConstruct
    public void init() {
        topicRepository.saveAll(Arrays.asList(new Topic("Java", "Core Java", "Core java desc"),
                new Topic("Multithreading", "Java Multithreading", "Java concurrence in practice"),
                new Topic("Spring", "Spring Boot", "Spring Boot rest demo")));        
    }
    
    public List<Topic> getAllTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }
    public Topic topicById(String id) {
        return topicRepository.findById(id).orElse(new Topic());
//       return topics.stream().filter(t->t.getId().equals(id)).findFirst().orElse(new Topic());
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) { 
        topicRepository.deleteById(id);
    }
}
