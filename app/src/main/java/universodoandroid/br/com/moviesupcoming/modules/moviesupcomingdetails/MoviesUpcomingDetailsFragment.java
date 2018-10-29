package universodoandroid.br.com.moviesupcoming.modules.moviesupcomingdetails;

import android.arch.persistence.room.Room;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import universodoandroid.br.com.moviesupcoming.R;
import universodoandroid.br.com.moviesupcoming.database.moviesupcoming.MovieDatabase;
import universodoandroid.br.com.moviesupcoming.databinding.MoviesUpcomingDetailsFragmentBinding;

import static universodoandroid.br.com.moviesupcoming.modules.moviesupcoming.MoviesUpcomingFragment.DATABASE_NAME;
import static universodoandroid.br.com.moviesupcoming.modules.moviesupcoming.MoviesUpcomingFragment.KEY_MOVIE_ID;

public class MoviesUpcomingDetailsFragment extends android.support.v4.app.Fragment{

    private MoviesUpcomingDetailsFragmentBinding mMoviesUpcomingDetailsFragmentBinding;
    private MovieDatabase movieDatabase;
    private Integer mMovieId;

    public static MoviesUpcomingDetailsFragment newInstance() {
        return new MoviesUpcomingDetailsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        mMovieId = bundle.getInt(KEY_MOVIE_ID);

        movieDatabase = Room.databaseBuilder(getContext(), MovieDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries()
                .build();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mMoviesUpcomingDetailsFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.movies_upcoming_details_fragment, container, false);

        mMoviesUpcomingDetailsFragmentBinding.moviesUpcomingDetailsToolbar.setTitle(
                movieDatabase.daoAccessMovies().getMovie(mMovieId).getTitle());

        return mMoviesUpcomingDetailsFragmentBinding.getRoot();
    }
}
