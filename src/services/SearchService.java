package services;

import models.Movie;
import models.Show;
import models.Theatre;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SearchService {
    private List<Theatre> allTheaters = new ArrayList<>();
    private List<Show> allShows = new ArrayList<>();

    public List<Theatre> getTheatresByCity(String cityId){
        return allTheaters.stream().filter(t -> t.getCityId().equals(cityId)).collect(Collectors.toList());
    }
    public List<Movie> getMovieByCity(String cityId){
        List<Theatre>cityTheatre = getTheatresByCity(cityId);
        Set<String>cityTheatreIds = new HashSet<>();
        for(Theatre theatre : cityTheatre){
            cityTheatreIds.add(theatre.getId());
        }

        Set<Movie>uniqueMovieInCity = new HashSet<>();

        for (Show show : allShows) {
            String showTheatreId  = show.getScreen().getTheatreId();
            if (cityTheatreIds.contains(showTheatreId)) {
                uniqueMovieInCity.add(show.getMovie());
            }
        }

        return new ArrayList<>(uniqueMovieInCity);
    }
}
