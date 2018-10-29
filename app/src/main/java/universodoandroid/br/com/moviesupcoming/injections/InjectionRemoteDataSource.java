package universodoandroid.br.com.moviesupcoming.injections;

import universodoandroid.br.com.moviesupcoming.services.moviesupcoming.MoviesUpcomingApiDataSource;
import universodoandroid.br.com.moviesupcoming.services.moviesupcoming.MoviesUpcomingRemoteDataSource;
import universodoandroid.br.com.moviesupcoming.services.moviesupcoming.MoviesUpcomingRemoteDataSourceImpl;

public class InjectionRemoteDataSource {

    public static MoviesUpcomingRemoteDataSource provideMoviesUpcomingRemoteDataSource() {
        MoviesUpcomingApiDataSource moviesUpcomingApiDataSource =
                InjectionApiDataSourceMain.provideMoviesUpcomingApiDataSource();

        return MoviesUpcomingRemoteDataSourceImpl.getInstance(moviesUpcomingApiDataSource);
    }

}
