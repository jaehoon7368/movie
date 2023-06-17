package com.sh.movie.domain.theater;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TheaterReposity extends JpaRepository<Theater,Long> {

    @Query("SELECT t FROM Theater t JOIN FETCH t.cinema ORDER BY t.no")
    List<Theater> findAll();


}
