package com.sh.movie.web;

import com.sh.movie.service.movie.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MovieController {

    private final MovieService movieService;

    //영화 상세 정보 조회
//    @GetMapping("/movies/{no}")
//    public MovieResponseDto findById (@PathVariable Long no){
//        return movieService.findByNo(no);
//    }
}
