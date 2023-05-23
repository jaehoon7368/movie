package com.sh.movie.web;

import com.sh.movie.service.board.BoardService;
import com.sh.movie.web.dto.BoardDto;
import com.sh.movie.web.dto.BoardResponseDto;
import com.sh.movie.web.dto.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/boards")
    public Long save(@RequestBody BoardDto boardDto){
        return boardService.save(boardDto);
    }

    @PutMapping("/boards/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto boardDto){
        return boardService.update(id, boardDto);
    }

    @GetMapping("/boards/{id}")
    public BoardResponseDto findById (@PathVariable Long id){
        return boardService.findById(id);
    }

}
