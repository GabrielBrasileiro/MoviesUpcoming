package universodoandroid.br.com.moviesupcoming.services.moviesupcoming;

import universodoandroid.br.com.moviesupcoming.BaseRemoteDataSource.RemoteDataSourceCallback;

public interface MoviesUpcomingRemoteDataSource {
    void loadMovies(RemoteDataSourceCallback callback);
}
