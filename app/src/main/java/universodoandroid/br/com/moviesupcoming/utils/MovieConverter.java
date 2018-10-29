package universodoandroid.br.com.moviesupcoming.utils;

import java.util.ArrayList;
import java.util.List;

import universodoandroid.br.com.moviesupcoming.database.moviesupcoming.MovieData;
import universodoandroid.br.com.moviesupcoming.domain.Movie;
import universodoandroid.br.com.moviesupcoming.modules.moviesupcoming.dto.MovieDto;
import universodoandroid.br.com.moviesupcoming.services.moviesupcoming.responses.MovieResponse;

public class MovieConverter {

    public static List<Movie> movieResponseToEntity(List<MovieResponse> moviesResponses) {
        List<Movie> movies = new ArrayList<>();

        for (MovieResponse movieResponse : moviesResponses) {
            movies.add(new Movie(
                    movieResponse.getVote_count(),
                    movieResponse.getId(),
                    movieResponse.getVideo(),
                    movieResponse.getVote_avarage(),
                    movieResponse.getTitle(),
                    movieResponse.getPopularity(),
                    movieResponse.getPoster_path(),
                    movieResponse.getOriginal_language(),
                    movieResponse.getGenre_ids(),
                    movieResponse.getBackdrop_path(),
                    movieResponse.getAdult(),
                    movieResponse.getOverview(),
                    movieResponse.getRelease_date()
            ));
        }

        return movies;
    }

    public static List<MovieDto> movieEntityToDto(List<Movie> moviesEntity) {
        List<MovieDto> movieDtos = new ArrayList<>();

        for (Movie movie : moviesEntity) {
            movieDtos.add(new MovieDto(
                    movie.getId(),
                    movie.getTitle(),
                    movie.getPosterPath(),
                    movie.getReleaseDate()
            ));
        }

        return movieDtos;
    }

    public static List<MovieData> movieEntityToData(List<Movie> moviesEntity) {
        List<MovieData> movieDatas = new ArrayList<>();

        for (Movie movie : moviesEntity) {
            movieDatas.add(new MovieData(
                    movie.getId(),
                    movie.getVideo(),
                    movie.getVoteAvarage(),
                    movie.getTitle(),
                    movie.getPopularity(),
                    movie.getPosterPath(),
                    movie.getOriginalLanguage(),
                    movie.getBackdropPath(),
                    movie.getAdult(),
                    movie.getOverview(),
                    movie.getReleaseDate()
            ));
        }

        return movieDatas;
    }

    public static List<MovieDto> movieDataToDto(List<MovieData> movies) {
        List<MovieDto> movieDtos = new ArrayList<>();

        for (MovieData movieData : movies) {
            movieDtos.add(new MovieDto(
                    movieData.getId(),
                    movieData.getTitle(),
                    null,
                    movieData.getReleaseDate()
            ));
        }

        return movieDtos;
    }

}
