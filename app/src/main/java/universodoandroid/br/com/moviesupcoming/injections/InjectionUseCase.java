package universodoandroid.br.com.moviesupcoming.injections;

import universodoandroid.br.com.moviesupcoming.modules.moviesupcoming.usecase.GetMoviesUpcoming;

public class InjectionUseCase {

    public static GetMoviesUpcoming provideGetMoviesUpcoming() {
        return new GetMoviesUpcoming(InjectionRemoteDataSource.provideMoviesUpcomingRemoteDataSource());
    }

}
