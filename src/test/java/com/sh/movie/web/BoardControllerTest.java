package com.sh.movie.web;

import com.sh.movie.domain.board.Board;
import com.sh.movie.domain.board.BoardRepository;
import com.sh.movie.web.dto.BoardDto;
import com.sh.movie.web.dto.BoardUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BoardRepository boardRepository;




    @AfterEach
    public void tearDown() throws Exception {
        boardRepository.deleteAll();
    }

    @Test
    public void boardPsot() throws Exception {
        //given
        String title = "title";
        String content = "content";
        BoardDto boardDto = BoardDto.builder()
                .title(title)
                .content(content)
                .author("author")
                .build();

        String url = "http://localhost:" + port + "/boards";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, boardDto, Long.class);

        //then
        List<Board> all = boardRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }

    @Test
    public void BoardUpdate() throws Exception{
        //given
        Board savedBoard = boardRepository.save(Board.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        Long updateId = savedBoard.getId();
        String expectedTitle = "title2";
        String expectedContent = "content2";

        BoardUpdateRequestDto boardDto = BoardUpdateRequestDto.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .build();

        String url = "http://localhost:" + port + "/boards/" + updateId;

        HttpEntity<BoardUpdateRequestDto> requestEntity = new HttpEntity<>(boardDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Board> all = boardRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
    }
}
