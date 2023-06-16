package app.repository;

import app.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashMap;
import java.util.List;

public interface SportRepository extends JpaRepository<Sport, Integer> {

    @Query(value = "select s.name as sportName, t.name as tourName, m.name as matchName, m.id as matchId, m.format as format, m.startTime as startTime from matches m left join tours t on m.tourId = t.id left join sports s on t.sportId = s.id", nativeQuery = true)
    public List getAllSportsToursAndMatches(String id);
}
