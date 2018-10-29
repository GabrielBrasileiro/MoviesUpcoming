package universodoandroid.br.com.moviesupcoming.services.moviesupcoming.responses;

import java.util.List;

public class MovieListResponse {

    private int total_pages;
    private List<MovieResponse> results;

    public int getTotal_pages() {
        return total_pages;
    }

    public List<MovieResponse> getResults() {
        return results;
    }

}
