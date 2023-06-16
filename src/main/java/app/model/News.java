package app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "news")
@Getter
@Setter
public class News {
    @Id
    private int id;
    private String title;
    private String description;

    @JsonIgnore
    private int typeId;
    @JsonIgnore
    private String type;
}
