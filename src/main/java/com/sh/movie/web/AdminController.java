package com.sh.movie.web;

import com.sh.movie.service.movie.MovieService;
import com.sh.movie.service.schedule.ScheduleService;
import com.sh.movie.service.theater.TheaterService;
import com.sh.movie.web.dto.schedule.ScheduleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RequiredArgsConstructor
@RestController
public class AdminController {

    private final ScheduleService scheduleService;
    private final MovieService movieService;
    private final TheaterService theaterService;

    @PostMapping("/admin/schedule-save")
    public RedirectView scheduleSave(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)ScheduleDto scheduleDto){
        Long scheduleSave = scheduleService.scheduleSave(scheduleDto);

        // /admin으로 리다이렉트 시키기
        RedirectView redirectView = new RedirectView("/admin");

        // 선택적으로 성공적인 저장을 나타내는 플래그를 추가할 수 있습니다.
        redirectView.addStaticAttribute("success", true);

        return redirectView;
    }
}
