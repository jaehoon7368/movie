package com.sh.movie.domain.board;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_board_generator")
    @SequenceGenerator(name = "seq_board_generator", sequenceName = "SEQ_BOARD", allocationSize = 1)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 4000, nullable = false)
    private String content;

    private String author;

    @Builder
    public Board(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
