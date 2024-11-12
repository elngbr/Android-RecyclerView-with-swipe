package com.example.myapplication.model;

import java.util.Date;

public class Movie {

    private String title;     //1
    private Date release;      // 2
    private Integer duration;  // 3
    private Boolean recommended;  // 4
    private Float rating;      //5
    private GenreEnum genre;   // 6
    private Double budget;     //7
    private String posterUrl;  // 8
    private int posterResId;   // 9
    private ParentalApprovalEnum approval; // 10

    // Constructor for Movie class
    public Movie(String title, Date release, Integer duration, Boolean recommended, Float rating, GenreEnum genre, Double budget, String posterUrl, int posterResId, ParentalApprovalEnum approval) {
        this.title = title;
        this.release = release;
        this.duration = duration;
        this.recommended = recommended;
        this.rating = rating;
        this.genre = genre;
        this.budget = budget;
        this.posterUrl = posterUrl;
        this.posterResId = posterResId;
        this.approval = approval;
    }

    // all the getters..we need them in adapter
    public String getTitle() {
        return title;
    }

    public Date getRelease() {
        return release;
    }

    public Integer getDuration() {
        return duration;
    }

    public Boolean getRecommended() {
        return recommended;
    }

    public Float getRating() {
        return rating;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public Double getBudget() {
        return budget;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public int getPosterResId() {
        return posterResId;
    }

    public ParentalApprovalEnum getApproval() {
        return approval;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", release=" + release +
                ", duration=" + duration +
                ", recommended=" + recommended +
                ", rating=" + rating +
                ", genre=" + genre.toString() +
                ", budget=" + budget +
                ", posterUrl='" + posterUrl + '\'' +
                ", approval=" + approval.toString() +  // Show approval status
                '}';
    }


}
