package universodoandroid.br.com.moviesupcoming.database.genre;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {GenreData.class}, version = 1, exportSchema = false)
public abstract class GenreDatabase extends RoomDatabase{
    public abstract DaoAccessGenres daoAccessGenres();
}
