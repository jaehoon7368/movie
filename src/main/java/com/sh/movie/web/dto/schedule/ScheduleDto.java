package com.sh.movie.web.dto.schedule;

import com.sh.movie.domain.schedule.Schedule;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleDto {

    private Long movieNo;
    private Long theaterNo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private  LocalDateTime endTime;

    @Builder
    public ScheduleDto(Long movieNo, Long theaterNo, LocalDateTime startTime, LocalDateTime endTime){
        this.movieNo = movieNo;
        this.theaterNo = theaterNo;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Schedule toEntity(){
        return Schedule.builder()
                .movieNo(movieNo)
                .theaterNo(theaterNo)
                .startTime(startTime)
                .endTime(endTime)
                .build();
    }
}
