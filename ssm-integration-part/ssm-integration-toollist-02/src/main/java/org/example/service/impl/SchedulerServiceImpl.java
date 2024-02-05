package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import org.example.mapper.SchedulerMapper;
import org.example.pojo.Schedule;
import org.example.service.SchedulerServcie;
import org.example.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulerServiceImpl implements SchedulerServcie {


    @Autowired
    private SchedulerMapper schedulerMapper;

    @Override
    public R page(int pageSize, int currentPage) {

        // 分页
        PageHelper.startPage(currentPage,pageSize); // sql  后面追加Limit x,y
        // 查询
        List<Schedule> scheduleList = schedulerMapper.queryList();
        // 分页数据装配
        return null;
    }
}
