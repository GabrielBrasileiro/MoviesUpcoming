package universodoandroid.br.com.moviesupcoming.services.moviesupcoming;

import java.util.List;

import universodoandroid.br.com.moviesupcoming.domain.Movie;

public interface MoviesUpcomingLocalDataSource {
    void onSucess(List<Movie> movies);
    void onError(String errorMessage);
}
