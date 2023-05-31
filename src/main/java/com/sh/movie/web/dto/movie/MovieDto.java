package com.sh.movie.web.dto.movie;

import com.sh.movie.domain.movie.Movie;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MovieDto {
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

    @Builder
    public MovieDto(String title, String genre, String director, String actors, String intro, int limitAge, Long runningTime, String openDate, Long reservationCount, String movieImage){
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

    public Movie toEntity(){
        return Movie.builder()
                .title(title)
                .genre(genre)
                .director(director)
                .actors(actors)
                .intro(intro)
                .limitAge(limitAge)
                .runningTime(runningTime)
                .openDate(openDate)
                .reservationCount(reservationCount)
                .movieImage(movieImage)
                .build();
    }
}
