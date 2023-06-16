package app.repository;

import app.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Integer> {

    @Query(value = "select * from News n where n.type = ? and n.typeId = ?", nativeQuery = true)
    List<News> getNewsByType(String type, String id);

    @Query(value = "select * from News n where n.type = 'MATCH' and " +
            " and n.typeId IN (select id from Matches m where m.tourId = ?)", nativeQuery = true)
    List<News> getTourNews(String tourId);

}
