package universodoandroid.br.com.moviesupcoming.database.moviesupcoming;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class MovieData {

    @NonNull
    @PrimaryKey
    private Integer id;
    private Boolean video;
    private Float voteAvarage;
    private String title;
    private Float popularity;
    private String posterPath;
    private String originalLanguage;
    private String backdropPath;
    private Boolean adult;
    private String overview;
    private String releaseDate;

    public MovieData(@NonNull Integer id, Boolean video, Float voteAvarage,
                     String title, Float popularity, String posterPath, String originalLanguage,
                     String backdropPath, Boolean adult, String overview, String releaseDate) {
        this.id = id;
        this.video = video;
        this.voteAvarage = voteAvarage;
        this.title = title;
        this.popularity = popularity;
        this.posterPath = posterPath;
        this.originalLanguage = originalLanguage;
        this.backdropPath = backdropPath;
        this.adult = adult;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Float getVoteAvarage() {
        return voteAvarage;
    }

    public void setVoteAvarage(Float voteAvarage) {
        this.voteAvarage = voteAvarage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPopularity() {
        return popularity;
    }

    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
