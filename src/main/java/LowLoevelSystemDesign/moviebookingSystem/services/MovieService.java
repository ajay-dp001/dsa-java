package LowLoevelSystemDesign.moviebookingSystem.services;

import LowLoevelSystemDesign.moviebookingSystem.exceptions.NotFoundException;
import LowLoevelSystemDesign.moviebookingSystem.model.Movie;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import lombok.NonNull;

public class MovieService {

  private final Map<String, Movie> movieMap;

  public MovieService() {
    movieMap = new HashMap<>();
  }

  public Movie getMovie(@NonNull final String movieId) throws NotFoundException {
    if (!movieMap.containsKey(movieId)) {
      throw new NotFoundException("Movie with movieId :" + movieId + " doesn't exist.!");
    }
    return movieMap.get(movieId);
  }

  public Movie createMovie(@NonNull final String movieName) {
    String movieId = UUID.randomUUID().toString();
    Movie newMovie = new Movie(movieId, movieName);
    movieMap.put(movieId, newMovie);
    return newMovie;
  }

}
