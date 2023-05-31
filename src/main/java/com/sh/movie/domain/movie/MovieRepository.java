package com.sh.movie.domain.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("select m from Movie m order by m.no")
    List<Movie> findAllDesc();

}
