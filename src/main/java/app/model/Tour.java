package app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity(name = "tours")
@Getter
@Setter
public class Tour {
    @Id
    private int id;
    private String name;
    private boolean status;
    private Timestamp startTime;
    private Timestamp endTime;

    private Timestamp createdAt;
    private Timestamp recUpdatedAt;

    @ManyToOne
    @JoinColumn(name = "sportId")
    private Sport sport;
}

