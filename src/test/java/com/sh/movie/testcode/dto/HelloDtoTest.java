package com.sh.movie.testcode.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloDtoTest {

    @Test
    public void lombokTest(){
        String name = "test";
        int amount = 1000;

        HelloDto dto = new HelloDto(name,amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
