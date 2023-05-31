package com.sh.movie.service.movie;

import com.sh.movie.domain.movie.MovieRepository;
import com.sh.movie.web.dto.movie.MovieListResponseDto;
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
}
