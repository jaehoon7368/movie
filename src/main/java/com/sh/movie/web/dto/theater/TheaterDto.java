package com.sh.movie.web.dto.theater;

import com.sh.movie.domain.cinema.Cinema;
import com.sh.movie.domain.theater.Theater;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TheaterDto {
    private int theaterNo;
    private Cinema cinema;

    @Builder
    public TheaterDto(int theaterNo, Cinema cinema){
        this.theaterNo = theaterNo;
        this.cinema = cinema;
    }

    public Theater toEntity(){
        return Theater.builder()
                .theaterNo(theaterNo)
                .cinema(cinema)
                .build();
    }
}
