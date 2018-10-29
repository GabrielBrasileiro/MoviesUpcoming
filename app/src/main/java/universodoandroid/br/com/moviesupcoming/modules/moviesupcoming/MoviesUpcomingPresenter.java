package universodoandroid.br.com.moviesupcoming.modules.moviesupcoming;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import universodoandroid.br.com.moviesupcoming.UseCase;
import universodoandroid.br.com.moviesupcoming.domain.Movie;
import universodoandroid.br.com.moviesupcoming.modules.moviesupcoming.usecase.GetMoviesUpcoming;

public class MoviesUpcomingPresenter implements MoviesUpcomingContract.Presenter {

    private final MoviesUpcomingContract.View mMoviesUpcomingView;
    private final GetMoviesUpcoming mGetMoviesUpcoming;

    public MoviesUpcomingPresenter(@NonNull MoviesUpcomingContract.View moviesUpcomingView,
                                   @NonNull GetMoviesUpcoming getMoviesUpcoming) {
        mMoviesUpcomingView = moviesUpcomingView;
        mGetMoviesUpcoming  = getMoviesUpcoming;

        mMoviesUpcomingView.setPresenter(this);
    }

    @Override
    public void loadMovies() {
        mGetMoviesUpcoming.getMoviesUpcoming(new UseCase.LoadUseCaseCallback<List<Movie>>() {
            @Override
            public void onLoaded(List<Movie> response) {
                mMoviesUpcomingView.showMovies(response);
            }

            @Override
            public void onEmptyData() {

            }

            @Override
            public void onFailed(String errorDescription) {
                mMoviesUpcomingView.showNoMovies();
                Log.e("ErrorToGetMovies", errorDescription);
            }
        });
    }
}
