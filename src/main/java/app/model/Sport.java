package app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity(name = "sports")
@Getter
@Setter
public class Sport {
    @Id
    private int id;
    private String name;
    private boolean status;
    private Timestamp createdAt;
    private Timestamp recUpdatedAt;
}
