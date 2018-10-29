package universodoandroid.br.com.moviesupcoming.services.moviesupcoming;

import universodoandroid.br.com.moviesupcoming.services.moviesupcoming.responses.MovieListResponse;
import retrofit2.http.GET;
import rx.Observable;

import static universodoandroid.br.com.moviesupcoming.BuildConfig.API_KEY;

public interface MoviesUpcomingApiDataSource {

    @GET("movie/upcoming?api_key=" + API_KEY)
    Observable<MovieListResponse> moviesUpcoming();

}
