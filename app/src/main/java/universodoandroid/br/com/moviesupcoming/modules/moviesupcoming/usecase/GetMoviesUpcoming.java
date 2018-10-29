package universodoandroid.br.com.moviesupcoming.modules.moviesupcoming.usecase;

import java.util.List;

import universodoandroid.br.com.moviesupcoming.BaseRemoteDataSource;
import universodoandroid.br.com.moviesupcoming.UseCase;
import universodoandroid.br.com.moviesupcoming.domain.Movie;
import universodoandroid.br.com.moviesupcoming.services.moviesupcoming.MoviesUpcomingRemoteDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

public class GetMoviesUpcoming {

    private final MoviesUpcomingRemoteDataSource moviesUpcomingRemoteDataSource;

    public GetMoviesUpcoming(MoviesUpcomingRemoteDataSource moviesUpcomingLocalDataSource) {
        this.moviesUpcomingRemoteDataSource = checkNotNull(moviesUpcomingLocalDataSource);
    }

    public void getMoviesUpcoming(UseCase.LoadUseCaseCallback<List<Movie>> useCaseCallback){
        moviesUpcomingRemoteDataSource.loadMovies(new BaseRemoteDataSource.RemoteDataSourceCallback<List<Movie>>() {
            @Override
            public void onSuccess(List<Movie> movies) {
                if (movies.isEmpty()){
                    useCaseCallback.onEmptyData();
                } else {
                    useCaseCallback.onLoaded(movies);
                }
            }

            @Override
            public void onError(String errorResponse) {
                useCaseCallback.onFailed(errorResponse);
            }
        });
    }


}
