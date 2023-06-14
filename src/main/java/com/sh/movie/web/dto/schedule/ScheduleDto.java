package com.sh.movie.web.dto.schedule;

import com.sh.movie.domain.movie.Movie;
import com.sh.movie.domain.schedule.Schedule;
import com.sh.movie.domain.theater.Theater;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleDto {

    private Movie movie;
    private Theater theater;
    private LocalDateTime startTime;
    private  LocalDateTime endTime;

    @Builder
    public ScheduleDto(Movie movie, Theater theater, LocalDateTime startTime, LocalDateTime endTime){
        this.movie = movie;
        this.theater = theater;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Schedule toEntity(){
        return Schedule.builder()
                .movie(movie)
                .theater(theater)
                .startTime(startTime)
                .endTime(endTime)
                .build();
    }
}
