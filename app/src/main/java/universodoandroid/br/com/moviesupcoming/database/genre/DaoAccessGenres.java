package universodoandroid.br.com.moviesupcoming.database.genre;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DaoAccessGenres {

    @Insert
    void insertMovies(List<GenreData> genres);

    @Query("SELECT * FROM GenreData WHERE id = :genreId")
    GenreData fetchOneMoviesbyMovieId(int genreId);

}
