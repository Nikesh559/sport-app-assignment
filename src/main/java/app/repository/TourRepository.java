package app.repository;

import app.model.Match;
import app.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Integer> {
    @Query(value = "select id from tour where sportId = ?", nativeQuery = true)
    List<Integer> getSportTourIds(String sportId);


}
