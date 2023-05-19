package com.sh.movie.web;

import com.sh.movie.service.board.BoardService;
import com.sh.movie.web.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private BoardService boardService;

    @PostMapping("/board")
    public Long save(@RequestBody BoardDto boardDto){
        return boardService.save(boardDto);
    }
}
