package net.talaatharb.movies.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data      //this class contains movie details
public class Movie {

   @Id
   public Integer Id;

    @Column(name = "language")
   public String originaLanguage;

    @Column(name = "title")
   public String Title;

    @Column(name = "overview")
    public String Overview;

    @Column(name = "posterPath")
    public String posterPath;

    @Column(name = "releasedate")
    public String releaseDate;

    @Column(name = "vote")
    public Integer voteAverage;

    @Column(name = "voteCount")
    public Integer voteCount;

    @Column(name = "video?")
    public boolean video;

    @Column(name = "adult?")
    public boolean Adult;

    @Column(name = "budget")
    public String Budget;

    @Column(name = "backdropPath")
    public String backdropPath;

    @Column(name = "imbId")
    public Integer imdbID;

    @Column(name = "status")
    public String Status;

    public Movie(Integer id, String originaLanguage, String title, String overview, String posterPath, String releaseDate, Integer voteAverage, Integer voteCount, boolean video, boolean adult, String budget, String backdropPath, Integer imdbID, String status) {
        Id = id;
        this.originaLanguage = originaLanguage;
        Title = title;
        Overview = overview;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.video = video;
        Adult = adult;
        Budget = budget;
        this.backdropPath = backdropPath;
        this.imdbID = imdbID;
        Status = status;
    }

    public Movie() {

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getOriginaLanguage() {
        return originaLanguage;
    }

    public void setOriginaLanguage(String originaLanguage) {
        this.originaLanguage = originaLanguage;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getOverview() {
        return Overview;
    }

    public void setOverview(String overview) {
        Overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Integer voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public boolean isAdult() {
        return Adult;
    }

    public void setAdult(boolean adult) {
        Adult = adult;
    }

    public String getBudget() {
        return Budget;
    }

    public void setBudget(String budget) {
        Budget = budget;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public Integer getImdbID() {
        return imdbID;
    }

    public void setImdbID(Integer imdbID) {
        this.imdbID = imdbID;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
