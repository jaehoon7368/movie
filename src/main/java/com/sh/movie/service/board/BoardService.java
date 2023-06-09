package com.sh.movie.service.board;

import com.sh.movie.domain.board.Board;
import com.sh.movie.domain.board.BoardRepository;
import com.sh.movie.web.dto.BoardDto;
import com.sh.movie.web.dto.BoardListResponseDto;
import com.sh.movie.web.dto.BoardResponseDto;
import com.sh.movie.web.dto.BoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardDto boardDto){
        return boardRepository.save(boardDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<BoardListResponseDto> findAllDesc(){
        return boardRepository.findAllDesc().stream()
                .map(BoardListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long update(Long id, BoardUpdateRequestDto boardDto){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        board.update(boardDto.getTitle(), boardDto.getContent());

        return id;
    }

    public BoardResponseDto findById(Long id){
        Board entity = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new BoardResponseDto(entity);
    }

    @Transactional
    public void delete(Long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        boardRepository.delete(board);
    }
}
