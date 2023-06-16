package app.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity(name = "matches")
@Getter
@Setter
public class Match {
    @Id
    private int id;
    private String name;
    private boolean status;
    private String format;
    private Timestamp createdAt;
    private Timestamp recUpdatedAt;

    @ManyToOne
    @JoinColumn(name = "tourId")
    private Tour tour;
}

