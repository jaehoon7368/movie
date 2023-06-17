package com.sh.movie.service.schedule;

import com.sh.movie.domain.schedule.ScheduleRepository;
import com.sh.movie.web.dto.schedule.ScheduleDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public Long scheduleSave(ScheduleDto scheduleDto){
        return scheduleRepository.save(scheduleDto.toEntity()).getNo();
    }
}
