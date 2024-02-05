package org.example.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.example.mapper.SchedulerMapper;
import org.example.pojo.Scheduler;
import org.example.service.SchedulerServcie;
import org.example.utils.PageBean;
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
        List<Scheduler> schedulerList = schedulerMapper.queryList();
        // 分页数据装配
        PageInfo<Scheduler> info = new PageInfo<>(schedulerList);

        // 装配配置Bean
        PageBean<Scheduler> pageBean = new PageBean<>(currentPage,pageSize,info.getTotal(),info.getList());

        //
        R ok = R.ok(pageBean);
        return ok;
    }

    @Override
    public R remove(Integer id) {
        int rows = schedulerMapper.deleteById(id);
        if (rows > 0){
            return R.ok(null);
        }
        return R.fail(null);
    }

    @Override
    public R save(Scheduler scheduler) {
        int rows = schedulerMapper.insert(scheduler);
        if (rows > 0){
            return R.ok(null);
        }
        return R.fail(null);
    }

    @Override
    public R update(Scheduler scheduler) {
        if(scheduler.getId() == null ){
            return R.fail("核心参数为空，无法修改！");
        }
        int rows = schedulerMapper.update(scheduler);
        if (rows > 0){
            return R.ok(null);
        }
        return R.fail(null);

    }
}
