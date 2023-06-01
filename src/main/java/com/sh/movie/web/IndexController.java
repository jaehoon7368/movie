package com.sh.movie.web;

import com.sh.movie.config.auth.LoginUser;
import com.sh.movie.config.auth.dto.SessionMUser;
import com.sh.movie.service.movie.MovieService;
import com.sh.movie.web.dto.movie.MovieResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final MovieService movieService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionMUser user){
        model.addAttribute("movies",movieService.findAllDesc());

        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/loginPage")
    public String loginPage(){
        return "loginPage";
    }

    @GetMapping("/movies/{no}") // 영화 상세 정보 조회
    public String movieInfo(@PathVariable Long no, Model model){
        MovieResponseDto movie = movieService.findByNo(no);
        model.addAttribute("movie",movie);

        return "movie-info";
    }

    @GetMapping("/boards/save")
    public String boardsSave(){
        return "boards-save";
    }

//    @GetMapping("/boards/update/{id}")
//    public String boardsUpdate(@PathVariable Long id, Model model){
//        BoardResponseDto dto = boardService.findById(id);
//        model.addAttribute("boards",dto);
//
//        return "boards-update";
//    }
}
