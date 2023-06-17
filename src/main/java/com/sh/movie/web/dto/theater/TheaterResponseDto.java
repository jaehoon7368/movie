package com.sh.movie.web.dto.theater;

import com.sh.movie.domain.cinema.Cinema;
import com.sh.movie.domain.theater.Theater;
import lombok.Getter;

@Getter
public class TheaterResponseDto {
    private Long no;
    private int theaterNo;
    private Cinema cinema;

    public TheaterResponseDto(Theater entity){
        this.no = entity.getNo();
        this.theaterNo = entity.getTheaterNo();
        this.cinema = entity.getCinema();
    }
}
