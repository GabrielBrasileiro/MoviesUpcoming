package universodoandroid.br.com.moviesupcoming.modules.moviesupcoming.dto;

public class MovieDto {

    private Integer id;
    private String title;
    private String posterPath;
    private String releaseDate;

    public MovieDto(Integer id, String title, String posterPath, String releaseDate) {
        this.id          = id;
        this.title       = title;
        this.posterPath  = posterPath;
        this.releaseDate = releaseDate;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
