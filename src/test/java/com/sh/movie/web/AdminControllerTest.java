package com.sh.movie.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sh.movie.domain.schedule.Schedule;
import com.sh.movie.domain.schedule.ScheduleRepository;
import com.sh.movie.web.dto.schedule.ScheduleDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdminControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach
    public void setup(){
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @AfterEach
    public void tearDown() throws Exception{
        scheduleRepository.deleteAll();
    }

    @Test
    public void schedulePost() throws Exception{
        //given
        Long movieNo = 1L;
        Long theaterNo = 1L;
        LocalDateTime startTime = LocalDateTime.of(2023, 6, 17, 21, 30);
        LocalDateTime endTime = LocalDateTime.of(2023, 6, 17, 23, 30);

        ScheduleDto scheduleDto = ScheduleDto.builder()
                .movieNo(movieNo)
                .theaterNo(theaterNo)
                .startTime(startTime)
                .endTime(endTime)
                .build();

        String url = "http://localhost:" + port + "/admin/schedule-save";

        //when
        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(new ObjectMapper().writeValueAsString(scheduleDto)))
                .andExpect(status().isOk());

        //then
        List<Schedule> all = scheduleRepository.findAll();
    }


}
