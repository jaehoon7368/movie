package com.sh.movie.domain.schedule;

import com.sh.movie.domain.movie.Movie;
import com.sh.movie.domain.theater.Theater;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_schedule_generator")
    @SequenceGenerator(name = "seq_schedule_generator", sequenceName = "SEQ_SCHEDULE", allocationSize = 1)
    private Long no;

    @ManyToOne
    @JoinColumn(name="movie_no",nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name="theater_no",nullable = false)
    private Theater theater;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Builder
    public Schedule(Movie movie, Theater theater, LocalDateTime startTime, LocalDateTime endTime){
        this.movie = movie;
        this.theater = theater;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
