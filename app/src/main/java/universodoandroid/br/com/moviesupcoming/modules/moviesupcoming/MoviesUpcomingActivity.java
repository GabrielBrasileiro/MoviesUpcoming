package universodoandroid.br.com.moviesupcoming.modules.moviesupcoming;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import universodoandroid.br.com.moviesupcoming.R;

public class MoviesUpcomingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_upcoming_activity);

        MoviesUpcomingFragment moviesUpcomingFragment = MoviesUpcomingFragment.newInstance();

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.movies_upcoming_content_frame, moviesUpcomingFragment);
        transaction.commit();
    }

}
