package com.sh.movie.web;

import com.sh.movie.service.board.BoardService;
import com.sh.movie.web.dto.BoardResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/boards/update/{id}")
    public String boardsUpdate(@PathVariable Long id, Model model){
        BoardResponseDto dto = boardService.findById(id);
        model.addAttribute("boards",dto);

        return "boards-update";
    }
}
