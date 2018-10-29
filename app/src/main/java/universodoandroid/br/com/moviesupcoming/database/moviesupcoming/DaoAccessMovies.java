package universodoandroid.br.com.moviesupcoming.database.moviesupcoming;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DaoAccessMovies {

    @Insert
    void insertMovie(MovieData movie);

    @Insert
    void insertMovies(List<MovieData> movieDataList);

    @Query("SELECT * FROM MovieData WHERE id = :movieId")
    MovieData getMovie(int movieId);

    @Query("SELECT * FROM MovieData")
    List<MovieData> getAllMovies();

    @Update
    void updateMovie(MovieData movieData);

    @Delete
    void deleteMovie(MovieData movieData);

}
