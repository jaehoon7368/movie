package com.sh.movie.service.board;

import com.sh.movie.domain.board.BoardRepository;
import com.sh.movie.web.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private BoardRepository boardRepository;

    @Transactional
    public Long save(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}
