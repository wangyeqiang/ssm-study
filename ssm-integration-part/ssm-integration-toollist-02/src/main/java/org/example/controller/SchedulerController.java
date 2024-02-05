package org.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.example.service.SchedulerServcie;
import org.example.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("scheduler")
@Slf4j
public class SchedulerController {


    @Autowired
    private SchedulerServcie schedulerServcie;

    // 接收参数，响应结果 springmvc
    @GetMapping("/{pageSize}/{currentPage}")
    public R page(@PathVariable int pageSize, @PathVariable int currentPage){

        R r = schedulerServcie.page(pageSize,currentPage);
        log.info("查询的数据为 :{}", r);
        return r ;
    }

}
