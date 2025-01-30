package com.itheima.controller;

import com.itheima.pojo.JobOption;
import com.itheima.pojo.Result;
import com.itheima.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/empJobData")
    public Result getEmpJobData() {
        log.info("查询员工工资报表");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success();
    }
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("查询员工性别人数");
        List<Map<String,Object>> genderList = reportService.getEmpGenderData();
        return Result.success(genderList);
    }
}
