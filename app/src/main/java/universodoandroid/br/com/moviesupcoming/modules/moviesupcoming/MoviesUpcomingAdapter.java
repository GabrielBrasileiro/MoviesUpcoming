package universodoandroid.br.com.moviesupcoming.modules.moviesupcoming;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import universodoandroid.br.com.moviesupcoming.R;
import universodoandroid.br.com.moviesupcoming.databinding.MoviesUpcomingItemBinding;
import universodoandroid.br.com.moviesupcoming.modules.moviesupcoming.dto.MovieDto;

public class MoviesUpcomingAdapter extends RecyclerView.Adapter<MoviesUpcomingAdapter.ViewHolder> {

    private List<MovieDto> mMovies;

    public MoviesUpcomingAdapter() {
        mMovies = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.movies_upcoming_item,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MovieDto movie = mMovies.get(position);
        holder.mMoviesUpcomingItemBinding.moviesUpcomingTitleTextView.setText(movie.getTitle());
        holder.mMoviesUpcomingItemBinding.moviesUpcomingDataTextView.setText(movie.getReleaseDate());
        holder.mMoviesUpcomingItemBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public MovieDto getMovie(int position) {
        return mMovies.get(position);
    }

    private void add(MovieDto constructionSiteDto) {
        mMovies.add(constructionSiteDto);
        notifyItemInserted(mMovies.size());
    }

    public void addAll(List<MovieDto> moveResults) {
        for (MovieDto result : moveResults) {
            add(result);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private MoviesUpcomingItemBinding mMoviesUpcomingItemBinding;

        ViewHolder(MoviesUpcomingItemBinding itemView) {
            super(itemView.getRoot());
            mMoviesUpcomingItemBinding = itemView;
        }
    }

}
