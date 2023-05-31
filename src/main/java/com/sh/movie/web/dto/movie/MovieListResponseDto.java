package com.sh.movie.web.dto.movie;

import com.sh.movie.domain.movie.Movie;
import lombok.Getter;

@Getter
public class MovieListResponseDto {
    private Long no;
    private String title; //제목
    private String genre; //장르
    private String director; //감독
    private String actors; //출연진
    private String intro; //소개
    private int limitAge; //관람등급
    private Long runningTime; //상영시간
    private String openDate; //개봉일
    private Long reservationCount; //예매수
    private String movieImage; //영화 이미지

    public MovieListResponseDto(Movie entity){
        this.no = entity.getNo();
        this.title = entity.getTitle();
        this.genre = entity.getGenre();
        this.director = entity.getDirector();
        this.actors = entity.getActors();
        this.intro = entity.getIntro();
        this.limitAge = entity.getLimitAge();
        this.runningTime = entity.getRunningTime();
        this.openDate = entity.getOpenDate();
        this.reservationCount = entity.getReservationCount();
        this.movieImage = entity.getMovieImage();
    }
}
