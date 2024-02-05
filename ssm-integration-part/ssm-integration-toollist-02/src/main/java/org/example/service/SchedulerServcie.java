package org.example.service;

import org.example.pojo.Scheduler;
import org.example.utils.R;

public interface SchedulerServcie {
    R page(int pageSize, int currentPage);

    R remove(Integer id);

    R save(Scheduler scheduler);

    R update(Scheduler scheduler);
}
