package universodoandroid.br.com.moviesupcoming.modules.moviesupcoming;


import android.arch.persistence.room.Room;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import universodoandroid.br.com.moviesupcoming.R;
import universodoandroid.br.com.moviesupcoming.database.moviesupcoming.MovieData;
import universodoandroid.br.com.moviesupcoming.database.moviesupcoming.MovieDatabase;
import universodoandroid.br.com.moviesupcoming.databinding.MoviesUpcomingFragmentBinding;
import universodoandroid.br.com.moviesupcoming.domain.Movie;
import universodoandroid.br.com.moviesupcoming.injections.InjectionUseCase;
import universodoandroid.br.com.moviesupcoming.modules.moviesupcoming.dto.MovieDto;
import universodoandroid.br.com.moviesupcoming.modules.moviesupcomingdetails.MoviesUpcomingDetailsActivity;
import universodoandroid.br.com.moviesupcoming.utils.RecyclerTouchListener;

import static com.google.common.base.Preconditions.checkNotNull;
import static universodoandroid.br.com.moviesupcoming.utils.MovieConverter.movieDataToDto;
import static universodoandroid.br.com.moviesupcoming.utils.MovieConverter.movieEntityToData;

public class MoviesUpcomingFragment extends Fragment implements MoviesUpcomingContract.View{

    public static final String DATABASE_NAME = "movies_db";
    public static final String KEY_MOVIE_ID = "movie_id";

    private MovieDatabase movieDatabase;
    private MoviesUpcomingContract.Presenter mPresenter;
    private MoviesUpcomingAdapter mMoviesUpcomingAdapter;
    private MoviesUpcomingFragmentBinding mMoviesUpcomingFragmentBinding;

    public static MoviesUpcomingFragment newInstance() {
        return new MoviesUpcomingFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        movieDatabase = Room.databaseBuilder(getContext(), MovieDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries()
                .build();

        mMoviesUpcomingAdapter = new MoviesUpcomingAdapter();
        new MoviesUpcomingPresenter(this, InjectionUseCase.provideGetMoviesUpcoming());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mMoviesUpcomingFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.movies_upcoming_fragment, container, false);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = mMoviesUpcomingFragmentBinding.moviesUpcomingRecyclerView;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(mMoviesUpcomingAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onLongClick(View view, int position) {}

            @Override
            public void onClick(View view, int position) {
                MovieDto movie = mMoviesUpcomingAdapter.getMovie(position);

                Intent intent = new Intent(getContext(), MoviesUpcomingDetailsActivity.class);
                intent.putExtra(KEY_MOVIE_ID, movie.getId());
                startActivity(intent);
            }
        }));

        mPresenter.loadMovies();

        return mMoviesUpcomingFragmentBinding.getRoot();
    }

    @Override
    public void showNoMovies() {

    }

    @Override
    public void showMovies(List<Movie> movies) {
        if (movieDatabase.daoAccessMovies().getAllMovies().size() == 0) {
            getActivity().runOnUiThread(() -> movieDatabase.daoAccessMovies().insertMovies(movieEntityToData(movies)));
        }

        List<MovieData> moviesData = movieDatabase.daoAccessMovies().getAllMovies();

        mMoviesUpcomingAdapter.addAll(movieDataToDto(moviesData));
    }

    @Override
    public void setPresenter(MoviesUpcomingContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }
}
