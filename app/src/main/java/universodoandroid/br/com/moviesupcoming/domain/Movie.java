package universodoandroid.br.com.moviesupcoming.domain;

import java.util.ArrayList;

public class Movie {

    private Integer id;
    private Integer voteCount;
    private Boolean video;
    private Float voteAvarage;
    private String title;
    private Float popularity;
    private String posterPath;
    private String originalLanguage;
    private ArrayList<Integer> genreIds;
    private String backdropPath;
    private Boolean adult;
    private String overview;
    private String releaseDate;

    public Movie(Integer voteCount, Integer id, Boolean video, Float voteAvarage, String title,
                 Float popularity, String posterPath, String originalLanguage, ArrayList<Integer> genreIds,
                 String backdropPath, Boolean adult, String overview, String releaseDate) {
        this.voteCount        = voteCount;
        this.id               = id;
        this.video            = video;
        this.voteAvarage      = voteAvarage;
        this.title            = title;
        this.popularity       = popularity;
        this.posterPath       = posterPath;
        this.originalLanguage = originalLanguage;
        this.genreIds         = genreIds;
        this.backdropPath     = backdropPath;
        this.adult            = adult;
        this.overview         = overview;
        this.releaseDate      = releaseDate;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public Integer getId() {
        return id;
    }

    public Boolean getVideo() {
        return video;
    }

    public Float getVoteAvarage() {
        return voteAvarage;
    }

    public String getTitle() {
        return title;
    }

    public Float getPopularity() {
        return popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public ArrayList<Integer> getGenreIds() {
        return genreIds;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
