package com.sh.movie.domain.cinema;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {

//    @Query("SELECT c FROM Cinema ORDER BY c.id DESC")
//    List<Cinema> findAll();
}
