package universodoandroid.br.com.moviesupcoming.services.moviesupcoming;

import android.support.annotation.NonNull;

import universodoandroid.br.com.moviesupcoming.BaseRemoteDataSource;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static com.google.common.base.Preconditions.checkNotNull;
import static universodoandroid.br.com.moviesupcoming.utils.MovieConverter.movieResponseToEntity;

public class MoviesUpcomingRemoteDataSourceImpl implements MoviesUpcomingRemoteDataSource {

    public static MoviesUpcomingRemoteDataSourceImpl INSTANCE = null;
    private final MoviesUpcomingApiDataSource mApiDataSource;

    public MoviesUpcomingRemoteDataSourceImpl(MoviesUpcomingApiDataSource mApiDataSource) {
        this.mApiDataSource = checkNotNull(mApiDataSource);
    }

    public static MoviesUpcomingRemoteDataSource getInstance(@NonNull MoviesUpcomingApiDataSource moviesUpcomingApiDataSource) {
        if (INSTANCE == null)
            INSTANCE = new MoviesUpcomingRemoteDataSourceImpl(moviesUpcomingApiDataSource);
        return INSTANCE;
    }

    @Override
    public void loadMovies(BaseRemoteDataSource.RemoteDataSourceCallback callback) {
        mApiDataSource.moviesUpcoming()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        (moviesList) ->
                                callback.onSuccess(movieResponseToEntity(moviesList.getResults())),
                        (throwable) ->
                                callback.onError(throwable.getMessage())
                );
    }
}
