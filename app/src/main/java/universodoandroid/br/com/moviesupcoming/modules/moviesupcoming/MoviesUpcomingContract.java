package universodoandroid.br.com.moviesupcoming.modules.moviesupcoming;

import java.util.List;

import universodoandroid.br.com.moviesupcoming.domain.Movie;

public interface MoviesUpcomingContract {

    interface View {
        void showNoMovies();
        void showMovies(List<Movie> movies);
        void setPresenter(Presenter presenter);
    }

    interface Presenter {
        void loadMovies();
    }

}
