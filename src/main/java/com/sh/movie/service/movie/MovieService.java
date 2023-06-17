package com.sh.movie.service.movie;

import com.sh.movie.domain.movie.Movie;
import com.sh.movie.domain.movie.MovieRepository;
import com.sh.movie.web.dto.movie.MovieListResponseDto;
import com.sh.movie.web.dto.movie.MovieResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public List<MovieListResponseDto> findAllDesc(){
        return movieRepository.findAllDesc().stream()
                .map(MovieListResponseDto::new)
                .collect(Collectors.toList());
    }

    public MovieResponseDto findByNo(Long no){
        Movie entity = movieRepository.findById(no)
                .orElseThrow(() -> new IllegalArgumentException("해당 영화는 없습니다. no="+no));

        return new MovieResponseDto(entity);
    }

}
