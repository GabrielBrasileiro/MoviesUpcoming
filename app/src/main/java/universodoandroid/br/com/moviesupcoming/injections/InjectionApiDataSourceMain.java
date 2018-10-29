package universodoandroid.br.com.moviesupcoming.injections;

import universodoandroid.br.com.moviesupcoming.BuildConfig;
import universodoandroid.br.com.moviesupcoming.services.ApiDataSource;
import universodoandroid.br.com.moviesupcoming.services.moviesupcoming.MoviesUpcomingApiDataSource;

public class InjectionApiDataSourceMain {

    public static ApiDataSource provideApiDataSource(){
        String baseUrl = BuildConfig.BASE_URL;
        return ApiDataSource.getInstance(baseUrl);
    }

    public static MoviesUpcomingApiDataSource provideMoviesUpcomingApiDataSource() {
        return provideApiDataSource().createService(MoviesUpcomingApiDataSource.class);
    }

}
