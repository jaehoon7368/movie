package com.sh.movie.domain.movie;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_movie_generator")
    @SequenceGenerator(name = "seq_movie_generator",sequenceName = "SEQ_MOVIE",allocationSize = 1)
    private Long no;

    @Column(nullable = false)
    private String title; //제목

    @Column(nullable = false)
    private String genre; //장르

    @Column(nullable = false)
    private String director; //감독

    @Column(nullable = false)
    private String actors; //출연진

    @Column(length = 4000,nullable = false)
    private String intro; //소개

    private int limitAge; //관람등급

    private Long runningTime; //상영시간

    private String openDate; //개봉일

    @ColumnDefault("0")
    private Long reservationCount; //예매수

    private String movieImage; //영화 이미지

    @Builder
    public Movie(String title, String genre, String director, String actors, String intro, int limitAge, Long runningTime, String openDate, Long reservationCount, String movieImage){
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.actors = actors;
        this.intro = intro;
        this.limitAge = limitAge;
        this.runningTime = runningTime;
        this.openDate = openDate;
        this.reservationCount = reservationCount;
        this.movieImage = movieImage;
    }
}
