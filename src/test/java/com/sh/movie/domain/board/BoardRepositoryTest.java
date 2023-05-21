package com.sh.movie.domain.board;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;


    @AfterEach
    public void cleanup(){
        boardRepository.deleteAll();
    }

    @Test
    public void boardSave_get(){
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        boardRepository.save(Board.builder()
                .title(title)
                .content(content)
                .author("Yoo JaeHoon")
                .build());

        //when
        List<Board> boardList = boardRepository.findAll();

        //then
        Board board = boardList.get(0);
        assertThat(board.getTitle()).isEqualTo(title);
        assertThat(board.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntityInit(){
        //given
        LocalDateTime now = LocalDateTime.of(2023,5,21,0,0,0);
        boardRepository.save(Board.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Board> boardList = boardRepository.findAll();

        //then
        Board board = boardList.get(0);

        System.out.println("createDate = " + board.getCreatedDate());
        System.out.println("modifiedDate = " + board.getModifiedDate());

        assertThat(board.getCreatedDate()).isAfter(now);
        assertThat(board.getModifiedDate()).isAfter(now);
    }
}
