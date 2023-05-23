package com.sh.movie.web;

import com.sh.movie.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@RequiredArgsConstructor
@Controller
public class IndexController {

    private final BoardService boardService;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("boards",boardService.findAllDesc());
        return "index";
    }

    @GetMapping("/boards/save")
    public String boardsSave(){
        return "boards-save";
    }
}
