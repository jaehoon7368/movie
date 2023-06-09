package com.sh.movie.web.dto.cinema;

import com.sh.movie.domain.cinema.Cinema;
import lombok.Getter;

@Getter
public class CinemaListResponseDto {
    private Long no;
    private String name;
    private String address;

    public CinemaListResponseDto(Cinema entity){
        this.no = entity.getNo();
        this.name= entity.getName();
        this.address = entity.getAddress();
    }
}
