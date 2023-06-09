package com.sh.movie.web.dto.cinema;

import com.sh.movie.domain.cinema.Cinema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CinemaDto {
    private String name;
    private String address;

    @Builder
    public CinemaDto(String name, String address){
        this.name = name;
        this.address = address;
    }

    public Cinema toEntity(){
        return Cinema.builder()
                .name(name)
                .address(address)
                .build();
    }

}
