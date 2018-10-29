package universodoandroid.br.com.moviesupcoming.database.moviesupcoming;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {MovieData.class}, version = 1, exportSchema = false)
public abstract class MovieDatabase extends RoomDatabase {
    public abstract DaoAccessMovies daoAccessMovies();
}
