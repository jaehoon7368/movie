package com.sh.movie.domain.cinema;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cinema_generator")
    @SequenceGenerator(name="seq_cinema_generator", sequenceName = "SEQ_CINEMA",allocationSize = 1)
    private Long no;

    @Column(nullable = false)
    private String name;

    @Column(length = 500, nullable = false)
    private String address;

    @Builder
    public Cinema(String name, String address){
        this.name = name;
        this.address = address;
    }
}
