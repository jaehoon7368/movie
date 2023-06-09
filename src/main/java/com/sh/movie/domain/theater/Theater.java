package com.sh.movie.domain.theater;

import com.sh.movie.domain.cinema.Cinema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_theater_generator")
    @SequenceGenerator(name="seq_theater_generator",sequenceName = "SEQ_THEATER",allocationSize = 1)
    private Long no;

    @Column(nullable = false)
    private int theaterNo;

    @ManyToOne
    @JoinColumn(name="cinema_no",nullable = false)
    private Cinema cinema;

    @Builder
    public Theater(int theaterNo, Cinema cinema){
        this.theaterNo = theaterNo;
        this.cinema = cinema;
    }
}
