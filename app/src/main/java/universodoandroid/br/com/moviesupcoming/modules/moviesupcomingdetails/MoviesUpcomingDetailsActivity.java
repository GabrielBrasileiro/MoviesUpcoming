package universodoandroid.br.com.moviesupcoming.modules.moviesupcomingdetails;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import universodoandroid.br.com.moviesupcoming.R;

import static universodoandroid.br.com.moviesupcoming.modules.moviesupcoming.MoviesUpcomingFragment.KEY_MOVIE_ID;

public class MoviesUpcomingDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_upcoming_details_activity);

        MoviesUpcomingDetailsFragment moviesUpcomingDetailsFragment = MoviesUpcomingDetailsFragment.newInstance();

        Integer movieId = getIntent().getIntExtra(KEY_MOVIE_ID, 0);

        Bundle bundle = new Bundle();
        bundle.putInt(KEY_MOVIE_ID, movieId);

        moviesUpcomingDetailsFragment.setArguments(bundle);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.movies_upcoming_details_content_frame, moviesUpcomingDetailsFragment);
        transaction.commit();
    }
}
