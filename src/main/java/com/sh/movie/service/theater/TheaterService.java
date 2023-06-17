package com.sh.movie.service.theater;

import com.sh.movie.domain.theater.Theater;
import com.sh.movie.domain.theater.TheaterReposity;
import com.sh.movie.web.dto.theater.TheaterListResponseDto;
import com.sh.movie.web.dto.theater.TheaterResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TheaterService {

    private final TheaterReposity theaterReposity;

    @Transactional(readOnly = true)
    public List<TheaterListResponseDto> findAll(){
        return theaterReposity.findAll().stream()
                .map(TheaterListResponseDto::new)
                .collect(Collectors.toList());
    }

    public TheaterResponseDto findByNo(Long theaterNo) {
        Theater entity = theaterReposity.findById(theaterNo)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+theaterNo));

        return new TheaterResponseDto(entity);
    }
}
