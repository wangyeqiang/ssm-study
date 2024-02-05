package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.pojo.Scheduler;
import org.example.service.SchedulerServcie;
import org.example.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("scheduler")
@Slf4j
public class SchedulerController {


    @Autowired
    private SchedulerServcie schedulerServcie;

    // 接收参数，响应结果 springmvc
    @GetMapping("/{pageSize}/{currentPage}")
    public R page(@PathVariable int pageSize, @PathVariable int currentPage) {
        System.out.println("fuck");
        R r = schedulerServcie.page(pageSize, currentPage);
        log.info("查询的数据为 :{}", r);
        return r;
    }


    @DeleteMapping("/{id}")
    public R remove(@PathVariable Integer id) {
        R r = schedulerServcie.remove(id);
        return r;
    }

    @PostMapping
    public R save(@Validated @RequestBody Scheduler scheduler, BindingResult result) {
        if (result.hasErrors()) {
            return R.fail("参数为空，不能保存！");
        }

        R r = schedulerServcie.save(scheduler);
        return r;

    }


    @PutMapping
    public R update(@Validated @RequestBody Scheduler scheduler, BindingResult result) {
        if (result.hasErrors()) {
            return R.fail("参数为空，不能修改！");
        }

        R r = schedulerServcie.update(scheduler);
        return r;

    }


}
