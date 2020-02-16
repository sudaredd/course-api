package app.boot.courseapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Entity
public class Course {
    @Id
    private String id;
    private String name;
    private String description;
    
    @ManyToOne
    private Topic topic;
}
