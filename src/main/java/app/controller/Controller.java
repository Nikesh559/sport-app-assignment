package app.controller;

import app.Cache;
import app.model.Match;
import app.model.News;
import app.model.Sport;
import app.model.Tour;
import app.repository.MatchRepository;
import app.repository.NewsRepository;
import app.repository.SportRepository;
import app.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private SportRepository sportRepository;

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private Cache cache;

    @GetMapping("/sport/{id}/tour/match")
    public List<Sport> getAllSportsToursAndMatches(@PathVariable String id) {
        return sportRepository.getAllSportsToursAndMatches(id);
    }

    @GetMapping("/tours/{tourName}/matches")
    public List<Match> getMatchesByTourName(@PathVariable String tourName) {
        if(cache.containsKey(tourName))
            return (List<Match>)cache.get(tourName);
        else {
            List<Match> matches = matchRepository.getMatchesByTourName(tourName);
            cache.set(tourName, matches);
            return matches;
        }
    }

    @GetMapping("/matches")
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @PostMapping("/news")
    public ResponseEntity createNews(@RequestBody News news) {
        newsRepository.save(news);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/sport/{sportId}/news")
    public List<News> getSportNews(@PathVariable String sportId) {
       List<Integer> tourIds = tourRepository.getSportTourIds(sportId);
       List<News> newsList = new ArrayList<>();

       for(Integer tourId : tourIds) {
           newsList.addAll(getTourNews(String.valueOf(tourId)));
       }
       return newsList;
    }

    @GetMapping("/tour/{tourId}/news")
    public List<News> getTourNews(@PathVariable  String tourId) {
        List<News> newsList = newsRepository.getNewsByType("TOUR", tourId);
        newsList.addAll(newsRepository.getTourNews(tourId));
        return newsList;
    }

    @GetMapping("/match/{matchId}/news")
    public List<News> getMatchNews(@PathVariable  String matchId) {
        return newsRepository.getNewsByType("MATCH", matchId);
    }

}
