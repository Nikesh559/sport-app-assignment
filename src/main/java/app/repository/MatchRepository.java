package app.repository;

import app.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Integer> {
    @Query(value = "select m.* from matches m left join tours t on m.tourId = t.id where t.name = ?", nativeQuery = true)
    List<Match> getMatchesByTourName(String tourName);
}
