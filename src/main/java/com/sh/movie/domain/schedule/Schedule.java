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
    @JoinColumn(name="movie_no",insertable = false, updatable = false)
    private Movie movie;

    @Column(name="movie_no")
    private Long movieNo;

    @ManyToOne
    @JoinColumn(name="theater_no",insertable = false, updatable = false)
    private Theater theater;

    @Column(name="theater_no")
    private Long theaterNo;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime endTime;

    @Builder
    public Schedule(Long movieNo, Long theaterNo, LocalDateTime startTime, LocalDateTime endTime){
        this.movieNo = movieNo;
        this.theaterNo = theaterNo;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
