package com.sh.movie.service.cinema;

import com.sh.movie.domain.cinema.CinemaRepository;
import com.sh.movie.web.dto.cinema.CinemaListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CinemaService {

    private final CinemaRepository cinemaRepository;

    public List<CinemaListResponseDto> findAll(){
        return cinemaRepository.findAll().stream()
                .map(CinemaListResponseDto::new)
                .collect(Collectors.toList());
    }
}
