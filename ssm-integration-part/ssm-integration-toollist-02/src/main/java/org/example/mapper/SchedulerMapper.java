package org.example.mapper;

import org.example.pojo.Scheduler;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchedulerMapper {
     List<Scheduler> queryList() ;

    int deleteById(Integer id);

    int insert(Scheduler scheduler);

    int update(Scheduler scheduler);
}
